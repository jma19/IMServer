package com.im.server.api;

import com.im.server.common.ServiceException;
import com.im.server.mode.*;
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

    @RequestMapping(path = "/querySendedNotices", method = RequestMethod.POST)
    public Response getSendedNotices(@RequestBody RequestNoticeEntity requestNoticeEntity) {
        logger.info(String.format("getSendedNotices方法收到请求数据, requestNoticeEntity=%s", requestNoticeEntity));
        if (isNull(requestNoticeEntity) || isNull(requestNoticeEntity.getPid()) || isNull(requestNoticeEntity.getFromRow())) {
            return Response.fail(ILLEGAL_PARAMETER_EXCEPTION.getMessage());
        }

        try {
            List<NoticeEntity> sendedNotices = noticePlanMgtService.getSendedNotices(requestNoticeEntity.getPid(), requestNoticeEntity.getFromRow(), requestNoticeEntity.getSize());
            return new Response().setStatus(SUCCESS).setData(sendedNotices);
        } catch (ServiceException e) {
            logger.error(String.format("querySendedNotices异常,error=%s", e.getMessage()));
            return Response.fail(ACCEESS_DB_EXCEPTION.getMessage());
        }

    }

    @RequestMapping(path = "/queryReceivedNotices", method = RequestMethod.POST)
    public Response getReceivedNotices(@RequestBody RequestNoticeEntity requestNoticeEntity) {
        logger.info(String.format("getReceivedNotices方法收到请求数据, requestNoticeEntity=%s", requestNoticeEntity));

        if (isNull(requestNoticeEntity) || isNull(requestNoticeEntity.getPid()) || isNull(requestNoticeEntity.getFromRow())) {
            return Response.fail(ILLEGAL_PARAMETER_EXCEPTION.getMessage());
        }

        try {
            List<NoticePlan> recivedNotices = noticePlanMgtService.getRecivedNotices(requestNoticeEntity.getPid(), requestNoticeEntity.getFromRow(), requestNoticeEntity.getSize());
            return new Response().setStatus(SUCCESS).setData(recivedNotices);
        } catch (ServiceException e) {
            logger.error(String.format("querySendedNotices异常,error=%s", e.getMessage()));
            return Response.fail(ACCEESS_DB_EXCEPTION.getMessage());
        }

    }


    @RequestMapping(value = "/queryUnReadNoticeCount/{pid}", method = RequestMethod.GET)
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

    @RequestMapping(value = "/queryNoticeContent/{noticeId}", method = RequestMethod.GET)
    public Response getNoticeContent(@PathVariable(value = "noticeId") Long noticeId) {
        logger.info(String.format("getNoticeContent方法收到请求数据, noticeId=%s", noticeId));
        try {
            NoticeBody notice = noticeMgtService.getNotice(noticeId);
            return new Response().setStatus(SUCCESS).setData(notice);
        } catch (ServiceException e) {
            logger.error(String.format("queryNoticeContent,error=%s", e.getMessage()));
            return Response.fail(e.getMessage());
        }
    }

    @RequestMapping(value = "/queryUnReadNoticeCount/{noticeId}", method = RequestMethod.GET)
    public Response getPersonCountOfUnreadNotice(@PathVariable(value = "noticeId") Long noticeId) {

        logger.info(String.format("getPersonCountOfUnreadNotice方法收到请求数据, noticeId=%s", noticeId));

        try {
            Integer personCountOfUnreadNotice = noticePlanMgtService.getPersonCountOfUnreadNotice(noticeId);
            return new Response().setStatus(SUCCESS).setData(personCountOfUnreadNotice);
        } catch (ServiceException e) {
            logger.error(String.format("getPersonCountOfUnreadNotice异常,error=%s", e.getMessage()));
            return Response.fail(e.getMessage());
        }
    }


    @RequestMapping(value = "/queryPersonCountOfReadNotice/{noticeId}", method = RequestMethod.GET)
    public Response getPersonCountOfReadNotice(@PathVariable(value = "noticeId") Long noticeId) {
        logger.info(String.format("getPersonCountOfReadNotice方法收到请求数据, noticeId=%s", noticeId));
        try {
            Integer personCountOfUnreadNotice = noticePlanMgtService.getPersonCountOfReadNotice(noticeId);
            return new Response().setStatus(SUCCESS).setData(personCountOfUnreadNotice);
        } catch (ServiceException e) {
            logger.error(String.format("getPersonCountOfReadNotice异常,error=%s", e.getMessage()));
            return Response.fail(e.getMessage());
        }
    }

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

}

