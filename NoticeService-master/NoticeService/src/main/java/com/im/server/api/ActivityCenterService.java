package com.im.server.api;

import com.im.server.common.ServiceException;
import com.im.server.mode.Response;
import com.im.server.mode.activity.ActivityEntity;
import com.im.server.service.ActivityMgtService;
import com.im.server.service.IdWorkerService;
import com.im.server.service.UploadFileService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(path = "/publish", method = RequestMethod.POST)
    public Response publish(@RequestBody ActivityEntity activityEntity) {

        logger.info(String.format("publish activity方法收到请求数据, activityEntity=%s", activityEntity));

        //参数check
        if (isNull(activityEntity) || isNull(activityEntity.getLocation()) || isNull(activityEntity.getPublisherPid())
                || isNull(activityEntity.getLocation())) {
            return Response.fail(ILLEGAL_PARAMETER_EXCEPTION.getMessage());
        }
        //将activity的主信息保存下来, 操作数据库插入, activity主信息的创建
        Long activityId = null;
        try {
            activityId = activityMgtService.createActiviy(activityEntity);
        } catch (ServiceException exp) {
            logger.error(String.format("插入activity信息失败"), exp);
        }
        //mi
        //创建activityId和url的绑定关系, 插入数据库
        if (activityEntity.getMultipartFiles() != null && !activityEntity.getMultipartFiles().isEmpty()) {
            uploadFileService.batchFileUpload(activityId, activityEntity.getMultipartFiles());
        }
        if(){

        }

        //创建创建在tb_activity_plan中插表


        //异步发布消息,
        return new Response().setStatus(SUCCESS);
    }

}
