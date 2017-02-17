package com.im.server.service;

import com.im.server.common.ExceptionConstants;
import com.im.server.common.ServiceException;
import com.im.server.dao.MajorServiceDao;
import com.im.server.mode.db.Major;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by majun on 16/3/5.
 */
@Service
public class MajorMgtService {

    private Log logger = LogFactory.getLog(MajorMgtService.class);

    @Autowired
    private MajorServiceDao majorServiceDao;


    public void createMajorEntity(Major major) throws ServiceException {
        try {
            majorServiceDao.createMajorEntity(major);
        } catch (Exception exp) {
            logger.error(String.format("数据库异常,插入专业信息失败, major=%s", major), exp);
            throw ExceptionConstants.ACCEESS_DB_EXCEPTION;
        }
    }

    public List<Major> getMajorEntities() throws ServiceException {

        try {
            return majorServiceDao.queryMajorEntities();
        } catch (Exception exp) {
            logger.error("数据库异常,获取专业信息失败", exp);
            throw ExceptionConstants.ACCEESS_DB_EXCEPTION;
        }
    }
}
