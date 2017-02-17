package com.im.server.api;

import com.im.server.common.ServiceException;
import com.im.server.mode.NoticeBodyResponse;
import com.im.server.mode.notice.*;
import com.im.server.mode.Response;
import com.im.server.mode.paramter.EnsureReadEntity;
import com.im.server.mode.paramter.NoticeBody;
import com.im.server.mode.paramter.RequestNoticeEntity;
import com.im.server.mode.paramter.SendNoticeRequestEntity;
import com.im.server.service.NoticeMgtService;
import com.im.server.service.NoticePlanMgtService;
import com.im.server.service.PersonMgtService;
import com.im.server.service.sender.NoticeEnsureMsgSender;
import com.im.server.service.sender.NoticeRequestMsgSender;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.im.server.common.Constants.Status.SUCCESS;
import static com.im.server.common.ExceptionConstants.ACCEESS_DB_EXCEPTION;
import static com.im.server.common.ExceptionConstants.ILLEGAL_PARAMETER_EXCEPTION;
import static com.im.server.utils.ParamerChecker.isNull;

/**
 * Created by majun on 16/1/22.
 */
@RestController
@RequestMapping("/notice/service")
public class NoticeCenterService {

    private Log logger = LogFactory.getLog(NoticeCenterService.class);

    @Autowired
    private NoticeRequestMsgSender noticeRequestService;

    @Autowired
    private NoticeEnsureMsgSender noticeEnsureMsgSender;

    @Autowired
    private NoticePlanMgtService noticePlanMgtService;

    @Autowired
    private NoticeMgtService noticeMgtService;

    @Autowired
    private PersonMgtService studentMgtService;

    @RequestMapping(path = "/sendNotice", method = RequestMethod.POST)
    public Response sendNotice(@RequestBody SendNoticeRequestEntity sendNoticesRequestEntity) {

        logger.info(String.format("sendMessage方法收到请求数据, sendNoticesRequestEntity=%s", sendNoticesRequestEntity));

        if (isNull(sendNoticesRequestEntity) || isNull(sendNoticesRequestEntity.getNoticeBody())
                || isNull(sendNoticesRequestEntity.getReceivers())
                || isNull(sendNoticesRequestEntity.getSender())
                || isNull(sendNoticesRequestEntity.getSender().getPid())
                || isNull(sendNoticesRequestEntity.getSender().getName())) {
            return Response.fail(ILLEGAL_PARAMETER_EXCEPTION.getMessage());
        }

        noticeRequestService.sendMessage(sendNoticesRequestEntity);

        return new Response().setStatus(SUCCESS);
    }

    @RequestMapping(path = "/ensureRead", method = RequestMethod.POST)
    public Response ensureRead(@RequestBody EnsureReadEntity ensureReadEntity) {

        logger.info(String.format("ensureRead方法收到请求数据, ensureReadEntity=%s", ensureReadEntity));

        if (isNull(ensureReadEntity) || isNull(ensureReadEntity.getNoticeId()) || isNull(ensureReadEntity.getPid())) {
            return Response.fail(ILLEGAL_PARAMETER_EXCEPTION.getMessage());
        }
        noticeEnsureMsgSender.sendMessage(ensureReadEntity);
        return new Response().setStatus(SUCCESS);
    }

    /**
     * 获取发送消息列表
     *
     * @param pid
     * @param fromRow
     * @return
     */
    @RequestMapping(path = "/getSendedNotices/{pid}/{fromRow}", method = RequestMethod.GET)
    public Response getSendedNotices(@PathVariable Long pid, @PathVariable Integer fromRow) {
        logger.info(String.format("getSendedNotices方法收到请求数据, pid=%s, fromRow=%s", pid, fromRow));
        if (isNull(pid) || isNull(fromRow)) {
            return Response.fail(ILLEGAL_PARAMETER_EXCEPTION.getMessage());
        }
        try {
            List<NoticeEntity> sendedNotices = noticePlanMgtService.getSendedNotices(pid, fromRow, 10);
            return Response.success(sendedNotices);
        } catch (ServiceException e) {
            logger.error(String.format("querySendedNotices异常,error=%s", e.getMessage()));
            return Response.fail(ACCEESS_DB_EXCEPTION.getMessage());
        }

    }

    /**
     *
     * @param pid
     * @param fromRow
     * @return
     */
    @RequestMapping(path = "/getReceivedNotices/{pid}/{fromRow}", method = RequestMethod.GET)
    public Response getReceivedNotices(@PathVariable Long pid, @PathVariable Integer fromRow) {
        logger.info(String.format("getReceivedNotices方法收到请求数据, pid=%s, fromRow=%s", pid, fromRow));

        if (isNull(pid) || isNull(fromRow)) {
            return Response.fail(ILLEGAL_PARAMETER_EXCEPTION.getMessage());
        }
        try {
            List<NoticeEntity> recivedNotices = noticePlanMgtService.getRecivedNotices(pid, fromRow, 10);
            return new Response().setStatus(SUCCESS).setData(recivedNotices);
        } catch (ServiceException e) {
            logger.error(String.format("querySendedNotices异常,error=%s", e.getMessage()));
            return Response.fail(ACCEESS_DB_EXCEPTION.getMessage());
        }

    }

    /**
     * 获取某个人未读消息个数
     *
     * @param pid
     * @return
     */
    @RequestMapping(value = "/getUnReadNoticeCount/{pid}", method = RequestMethod.GET)
    public Response getUnReadNoticeCount(@PathVariable(value = "pid") Long pid) {

        logger.info(String.format("getUnReadNoticeCount方法收到请求数据, pid=%s", pid));

        try {
            Integer unreadNoticeCount = noticePlanMgtService.getUnreadNoticeCount(pid);
            return new Response().setStatus(SUCCESS).setData(unreadNoticeCount);
        } catch (ServiceException e) {
            logger.error(String.format("querySendedNotices异常,error=%s", e.getMessage()));
            return Response.fail(ACCEESS_DB_EXCEPTION.getMessage());
        }
    }

    /**
     * 获取某个消息具体内容,包括未读人数和已读人数
     *
     * @param noticeId
     * @return
     */

    @RequestMapping(value = "/getNoticeContent/{noticeId}", method = RequestMethod.GET)
    public Response getNoticeContent(@PathVariable(value = "noticeId") Long noticeId) {
        logger.info(String.format("getNoticeContent方法收到请求数据, noticeId=%s", noticeId));
        try {
            NoticeBody notice = noticeMgtService.getNotice(noticeId);
            Integer unreadCount = noticePlanMgtService.getPersonCountOfUnreadNotice(noticeId);
            Integer readCount = noticePlanMgtService.getPersonCountOfReadNotice(noticeId);

            NoticeBodyResponse noticeBodyResponse = new NoticeBodyResponse().setNoticeBody(notice).setReadCount(readCount).setUnReadCount(unreadCount);
            return Response.success(noticeBodyResponse);
        } catch (ServiceException e) {
            logger.error(String.format("queryNoticeContent,error=%s", e.getMessage()));
            return Response.fail(e.getMessage());
        }
    }

    /**
     * 获取某条消息未读人员列表
     *
     * @param noticeId
     * @return
     */
    @RequestMapping(value = "/getUnreadPersonList/{noticeId}", method = RequestMethod.GET)
    public Response getUnreadPersonList(@PathVariable(value = "noticeId") Long noticeId) {
        logger.info(String.format("getUnreadPersonList方法收到请求数据, noticeId=%s", noticeId));
        try {
            List<ContactEntity> unreadPersonList = noticePlanMgtService.getUnreadPersonList(noticeId);
            return Response.success(unreadPersonList);
        } catch (ServiceException e) {
            logger.error(String.format("getPersonCountOfUnreadNotice异常,error=%s", e.getMessage()));
            return Response.fail(e.getMessage());
        }
    }

    /**
     * 获取某条消息已读人员列表
     *
     * @param noticeId
     * @return
     */
    @RequestMapping(value = "/getReadPersonList/{noticeId}", method = RequestMethod.GET)
    public Response getReadPersonList(@PathVariable(value = "noticeId") Long noticeId) {
        logger.info(String.format("getReadPersonList方法收到请求数据, noticeId=%s", noticeId));
        try {
            List<ContactEntity> unreadPersonList = noticePlanMgtService.getReadPersonList(noticeId);
            return Response.success(unreadPersonList);
        } catch (ServiceException e) {
            logger.error(String.format("getPersonCountOfUnreadNotice异常,error=%s", e.getMessage()));
            return Response.fail(e.getMessage());
        }
    }

    /**
     * 获取联系人列表
     *
     * @param typeId
     * @param pid
     * @return
     */
    @RequestMapping(value = "/getPersonContactList/{typeId}/{pid}", method = RequestMethod.GET)
    public Response getPersonContactList(@PathVariable(value = "typeId") Integer typeId, @PathVariable(value = "pid") Long pid) {
        logger.info(String.format("getPersonCountOfReadNotice方法收到请求数据, typeId=%s, pid=%s", typeId, pid));
        try {
            DivideInfo contactInfo = studentMgtService.getContactInfo(typeId, pid);
            return new Response().setData(contactInfo).setStatus(SUCCESS);
        } catch (ServiceException e) {
            logger.error(String.format("getPersonContactList,error=%s", e.getMessage()));
            return Response.fail(e.getMessage());
        }
    }


    @RequestMapping(value = "/notify", method = RequestMethod.POST)
    public Response notifyAgain(@RequestBody NotifyEntity notifyEntity) {
        logger.info(String.format("再次提醒方法收到请求数据, notifyEntity =%s", notifyEntity));
        if (isNull(notifyEntity) || isNull(notifyEntity.getNoticeId()) || isNull(notifyEntity.getSender())) {
            return Response.fail(ILLEGAL_PARAMETER_EXCEPTION.getMessage());
        }
        return new Response().setStatus(SUCCESS);
    }
    //notice

}

