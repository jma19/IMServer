package com.im.server.api;

import com.google.common.collect.Lists;
import com.im.server.common.ServiceException;
import com.im.server.mode.Response;
import com.im.server.mode.activity.*;
import com.im.server.service.ActivityMgtService;
import com.im.server.service.IdWorkerService;
import com.im.server.service.UploadFileService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static com.im.server.common.Constants.Status.SUCCESS;
import static com.im.server.common.ExceptionConstants.ILLEGAL_PARAMETER_EXCEPTION;
import static com.im.server.utils.ParamerChecker.isNull;

/**
 * Created by majun on 16/2/6.
 */
@RestController
@RequestMapping("/activity/service")
public class ActivityCenterService {

    private Log logger = LogFactory.getLog(NoticeCenterService.class);

    @Autowired
    private UploadFileService uploadFileService;

    @Autowired
    private IdWorkerService idWorkerService;

    @Autowired
    private ActivityMgtService activityMgtService;

    @RequestMapping(path = "/test", method = RequestMethod.POST)
    public Response publishTest(@RequestParam(value = "contentId") Integer contentId,
                                @RequestParam(value = "contentName") String name) {
        //ls
        logger.info(String.format("publish activity方法收到请求数据, activityEntity=%s", contentId));
        return Response.success(contentId + ":" + name);
    }


    @RequestMapping(path = "/publish", method = RequestMethod.POST)
    public Response publish(@RequestParam(value = "publisherId") Long publisherId,
                            @RequestParam(value = "publisherName") String publisherName,
                            @RequestParam(value = "publisherRemark", required = false) String publisherRemark,
                            @RequestParam(value = "level") Integer level,
                            @RequestParam(value = "title") String title,
                            @RequestParam(value = "des") String des,
                            @RequestParam(value = "location") String location,
                            @RequestParam(value = "startTime") String startTime,
                            @RequestParam(value = "endTime") String endTime,
                            @RequestParam(value = "pics", required = false) MultipartFile[] pics) {

        ActivityEntity activityEntity = new ActivityEntity()
                .setDes(des)
                .setLevel(level)
                .setPublisherPid(publisherId)
                .setPublisherName(publisherName)
                .setPublisherRemark(publisherRemark)
                .setMultipartFiles(Lists.newArrayList(pics))
                .setLocation(location)
                .setTitle(title)
                .setStartTime(startTime)
                .setEndTime(endTime);

        //ls
        logger.info(String.format("publish activity方法收到请求数据, activityEntity=%s", activityEntity));
        Long activityId = null;
        try {
            activityId = activityMgtService.createActiviy(activityEntity);
        } catch (ServiceException exp) {
            logger.error(String.format("插入activity信息失败"), exp);
        }
        //通过level获取id

        //
        //创建activityId和url的绑定关系, 插入数据库
        if (activityEntity.getMultipartFiles() != null && !activityEntity.getMultipartFiles().isEmpty()) {
            uploadFileService.batchFileUpload(activityId, activityEntity.getMultipartFiles());
        }

        //创建创建在tb_activity_plan中插表

        //异步发布消息,
        return new Response().setStatus(SUCCESS);
    }


    /**
     * @param pid
     * @param fromRow
     * @return
     */
    @RequestMapping(path = "/getActivities/{pid}/{fromRow}", method = RequestMethod.GET)
    public Response getActivities(@PathVariable Long pid, @PathVariable Integer fromRow) {
        logger.info(String.format("getActivities方法收到请求数据, pid=%s, fromRow=%s", pid, fromRow));
        //get
        try {
            return Response.success(activityMgtService.getActivities(pid, fromRow));
        } catch (ServiceException e) {
            return Response.fail(e.getMessage());
        }
    }

    /**
     * 查询pid参加的活动
     *
     * @param pid
     * @return
     */
    @RequestMapping(path = "/getAttendActivities/{pid}/{fromRow}", method = RequestMethod.GET)
    public Response getAttendedActivities(@PathVariable(value = "pid") Long pid, @PathVariable Integer fromRow) {
        logger.info(String.format("getAttendedActivities方法收到请求数据, pid=%s, fromRow=%s", pid, fromRow));
        try {
            return Response.success(activityMgtService.getAttendedActivityList(pid, fromRow));
        } catch (ServiceException e) {
            return Response.fail(e.getMessage());
        }
    }

    /**
     * 获取我即将参加的活动列表
     *
     * @param pid
     * @return
     */
    @RequestMapping(path = "/getMyActivities/{pid}/{fromRow}", method = RequestMethod.GET)
    public Response getAttendedAndNotHappenedActivities(@PathVariable(value = "pid") Long pid, @PathVariable Integer fromRow) {
        logger.info(String.format("getAttendedAndNotHappenedActivities方法收到请求数据, pid=%s, fromRow=%s", pid, fromRow));
        //startTime

        return Response.success(Lists.newArrayList(new ActivityDesContent()));
    }


    /**
     * 获取主页受到人们关注最多的活动
     *
     * @return
     */
    @RequestMapping(path = "/getMostInterestActivities", method = RequestMethod.GET)
    public Response getMostInterestActivities() {
        logger.info(String.format("publish activity方法收到请求数据, activityEntity"));
        return Response.success(Lists.newArrayList(new ActivityDesContent()));
    }


    /**
     * 根据activityId获取activity内容
     *
     * @param activityId
     * @return
     */
    @RequestMapping(path = "/getActivity/{activityId}", method = RequestMethod.GET)
    public Response getActivity(@PathVariable(value = "activityId") Long activityId) {
        logger.info(String.format("getActivities方法收到请求数据, activityId=%s", activityId));
        try {
            return Response.success(activityMgtService.getActivityContent(activityId));
        } catch (ServiceException e) {
            return Response.fail(e.getMessage());
        }
    }

    /**
     * 更新活动的状态
     *
     * @param activityStatusEntity
     * @return
     */

    @RequestMapping(path = "/updateActivityStatus", method = RequestMethod.POST)
    public Response updateActivityStatus(@RequestBody UpdateActivityStatusEntity activityStatusEntity) {

        if (isNull(activityStatusEntity.getStatus()) || isNull(activityStatusEntity.getPid())) {
            return Response.fail(ILLEGAL_PARAMETER_EXCEPTION.getMessage());
        }
        try {
            activityMgtService.updateActivityStatus(activityStatusEntity);
        } catch (ServiceException e) {
            return Response.fail(e.getMessage());
        }
        return Response.success(null);
    }

    /**
     * 获取个人发布的活动列表
     *
     * @param pid
     * @param fromRow
     * @return
     */
    @RequestMapping(path = "/getMyPublishedActivities/{pid}/{fromRow}", method = RequestMethod.GET)
    public Response getMyPublishedActivities(@PathVariable Long pid, @PathVariable Integer fromRow) {

        if (isNull(pid) || isNull(fromRow)) {
            return Response.fail(ILLEGAL_PARAMETER_EXCEPTION.getMessage());
        }
        try {
            return Response.success(activityMgtService.getPublishedActivities(pid, fromRow));
        } catch (ServiceException e) {
            return Response.fail(e.getMessage());
        }
    }

}
