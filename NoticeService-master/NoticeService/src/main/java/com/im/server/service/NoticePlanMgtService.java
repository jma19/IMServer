package com.im.server.service;

import com.google.common.collect.Lists;
import com.im.server.common.ExceptionConstants;
import com.im.server.common.ServiceException;
import com.im.server.dao.NoticePlanServiceDao;
import com.im.server.mode.ContactEntity;
import com.im.server.mode.NoticeEntity;
import com.im.server.mode.NoticePlan;
import com.im.server.mode.paramter.Sender;
import jdk.nashorn.internal.runtime.WithObject;
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
            List<NoticePlan> noticePlans = noticePlanServiceDao.querySendedNotices(pid, from, size);

            ArrayList<NoticeEntity> result = Lists.newArrayList();
            //根据noticeplans获取receivers list,sender info, and title, des
            Map<Long, List<NoticePlan>> collect = noticePlans.stream().collect(Collectors.groupingBy(noticePlan -> noticePlan.getNoticeId()));
            for (Long key : collect.keySet()) {
                NoticeEntity noticeEntity = getNoticeEntity(collect, key);
                result.add(noticeEntity);
            }
            return result;

        } catch (Exception exp) {
            logger.error("数据库异常,querySendedNotices失败", exp);
            throw ExceptionConstants.ACCEESS_DB_EXCEPTION;
        }
    }

    public List<NoticePlan> getRecivedNotices(Long pid, Integer from, Integer size) throws ServiceException {
        logger.info(String.format("getRecivedNotices, pid=%s, from=%s, size", pid, from, size));

        try {
            return noticePlanServiceDao.queryReceivedMessageNotice(pid, from, size);
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

    private NoticeEntity getNoticeEntity(Map<Long, List<NoticePlan>> collect, Long key) {
        List<NoticePlan> noticePlanList = collect.get(key);
        NoticePlan noticePlan = noticePlanList.get(0);
        return new NoticeEntity().
                setDes(noticePlan.getDes()).
                setSender(new Sender().setName(noticePlan.getSenderName()).setPid(noticePlan.getSenderPid()))
                .setTitle(noticePlan.getTitle())
                .setReceivers(getReceivers(collect.get(key)));
    }

    private List<ContactEntity> getReceivers(List<NoticePlan> noticePlanList) {
        return noticePlanList.stream()
                .map(noticePlan -> new ContactEntity().setName(noticePlan.getRecvName()).setPid(noticePlan.getRecvPid()))
                .collect(Collectors.toList());
    }


}
