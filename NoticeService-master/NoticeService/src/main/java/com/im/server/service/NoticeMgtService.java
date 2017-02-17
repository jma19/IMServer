package com.im.server.service;

import com.im.server.common.ExceptionConstants;
import com.im.server.common.ServiceException;
import com.im.server.dao.NoticeMgtServiceDao;
import com.im.server.mode.paramter.NoticeBody;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by majun on 16/1/21.
 */
@Service
public class NoticeMgtService {
    private final static Log logger = LogFactory.getLog(NoticeMgtService.class);

    @Autowired
    private NoticeMgtServiceDao noticeContentServiceDao;

    public void insertNotice(NoticeBody noticeBody) throws ServiceException {
        logger.info(String.format("插入notice, noticeBody=%s", noticeBody));
        try {
            noticeContentServiceDao.insertNotice(noticeBody);
        } catch (Exception exp) {
            logger.error("数据库异常,插入notice失败", exp);
            throw ExceptionConstants.ACCEESS_DB_EXCEPTION;
        }
    }

    public NoticeBody getNotice(Long noticeId) throws ServiceException {
        logger.info(String.format("获取noticeId, noticeId=%s", noticeId));
        try {
            return noticeContentServiceDao.queryNotice(noticeId);
        } catch (Exception exp) {
            logger.error("数据库异常,获取notice失败", exp);
            throw ExceptionConstants.ACCEESS_DB_EXCEPTION;
        }
    }
}
