package com.im.server.service;

import com.google.common.collect.Lists;
import com.im.server.common.ExceptionConstants;
import com.im.server.common.ServiceException;
import com.im.server.dao.NoticePlanServiceDao;
import com.im.server.mode.notice.ContactEntity;
import com.im.server.mode.notice.NoticeEntity;
import com.im.server.mode.notice.NoticePlan;
import com.im.server.mode.paramter.Sender;
import com.im.server.utils.ParamerChecker;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by majun on 16/1/21.
 */
@Service
public class NoticePlanMgtService {

    private final static Log logger = LogFactory.getLog(NoticePlanMgtService.class);

    @Autowired
    private NoticePlanServiceDao noticePlanServiceDao;


    public void insertNoticePlan(NoticePlan noticePlan) throws ServiceException {
        logger.info(String.format("插入noticePlan, noticePlan=%s", noticePlan));
        try {
            noticePlanServiceDao.insertNoticePlan(noticePlan);
        } catch (Exception exp) {
            logger.error("数据库异常,插入notice失败", exp);
            throw ExceptionConstants.ACCEESS_DB_EXCEPTION;
        }
    }

    public void insertNoticePlans(List<NoticePlan> noticePlans) throws ServiceException {
        logger.info(String.format("批量写入noticePlans, noticePlans=%s", noticePlans));
        try {
            noticePlanServiceDao.insertNoticePlans(noticePlans);
        } catch (Exception exp) {
            logger.error("数据库异常,批量插入notice失败", exp);
            throw ExceptionConstants.ACCEESS_DB_EXCEPTION;
        }


    }

    public void ensureRead(Long noticeId, Long pid) throws ServiceException {
        logger.info(String.format("ensureRead, noticeId=%s, pid=%s", noticeId, pid));
        try {
            noticePlanServiceDao.ensureRead(noticeId, pid);
        } catch (Exception exp) {
            logger.error("数据库异常,ensureRead失败", exp);
            throw ExceptionConstants.ACCEESS_DB_EXCEPTION;

        }
    }

    public List<NoticeEntity> getSendedNotices(Long pid, Integer from, Integer size) throws ServiceException {
        logger.info(String.format("getSendedNotices, pid=%s, from=%s, size", pid, from, size));
        try {
            return noticePlanServiceDao.querySendedNotices(pid, from, size);
        } catch (Exception exp) {
            logger.error("数据库异常,querySendedNotices失败", exp);
            throw ExceptionConstants.ACCEESS_DB_EXCEPTION;
        }
    }

    public List<NoticeEntity> getRecivedNotices(Long pid, Integer from, Integer size) throws ServiceException {
        logger.info(String.format("getRecivedNotices, pid=%s, from=%s, size", pid, from, size));
        try {
            return noticePlanServiceDao.queryReceivedNotices(pid, from, size);
        } catch (Exception exp) {
            logger.error("数据库异常, getRecivedNotices失败", exp);
            throw ExceptionConstants.ACCEESS_DB_EXCEPTION;
        }
    }

    public Integer getUnreadNoticeCount(Long pid) throws ServiceException {
        logger.info(String.format("getUnreadNoticeCount, pid=%s", pid));
        try {
            return noticePlanServiceDao.queryUnReadNoticeCount(pid);
        } catch (Exception exp) {
            logger.error("数据库异常,querySendedNotices失败", exp);
            throw ExceptionConstants.ACCEESS_DB_EXCEPTION;
        }
    }


    public Integer getPersonCountOfUnreadNotice(Long noticeId) throws ServiceException {
        logger.info(String.format("getPersonCountOfUnreadNotice, noticeId=%s", noticeId));
        try {
            return noticePlanServiceDao.queryUnReadNoticePersonCount(noticeId);
        } catch (Exception exp) {
            logger.error("数据库异常,queryUnReadNoticePersonCount失败", exp);
            throw ExceptionConstants.ACCEESS_DB_EXCEPTION;
        }
    }

    public Integer getPersonCountOfReadNotice(Long noticeId) throws ServiceException {
        logger.info(String.format("getPersonCountOfReadNotice, noticeId=%s", noticeId));
        try {
            return noticePlanServiceDao.queryReadNoticePersonCount(noticeId);
        } catch (Exception exp) {
            logger.error("数据库异常,queryReadNoticePersonCount失败", exp);
            throw ExceptionConstants.ACCEESS_DB_EXCEPTION;
        }
    }

    public List<ContactEntity> getUnreadPersonList(Long noticeId) throws ServiceException {
        logger.info(String.format("根据noticeId获取未读消息人员列表, noticeId=%s", noticeId));
        try {
            return noticePlanServiceDao.queryUnReadPersonList(noticeId);
        } catch (Exception exp) {
            logger.error("数据库异常, queryUnReadPersonList失败", exp);
            throw ExceptionConstants.ACCEESS_DB_EXCEPTION;
        }
    }


    public List<ContactEntity> getReadPersonList(Long noticeId) throws ServiceException {
        logger.info(String.format("根据noticeId获取已读消息人员列表, noticeId=%s", noticeId));
        try {
            return noticePlanServiceDao.queryReadNoticePersonList(noticeId);
        } catch (Exception exp) {
            logger.error("数据库异常, queryUnReadPersonList失败", exp);
            throw ExceptionConstants.ACCEESS_DB_EXCEPTION;
        }
    }


    private List<ContactEntity> getReceivers(List<NoticePlan> noticePlanList) {
        return noticePlanList.stream()
                .map(noticePlan -> new ContactEntity().setName(noticePlan.getRecvName()).setPid(noticePlan.getRecvPid()))
                .collect(Collectors.toList());
    }


}
