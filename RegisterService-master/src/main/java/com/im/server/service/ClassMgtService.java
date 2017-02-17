package com.im.server.service;

import com.im.server.common.ExceptionConstants;
import com.im.server.common.ServiceException;
import com.im.server.dao.ClassMgtServiceDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by majun on 16/3/19.
 */
@Service
public class ClassMgtService {

    private final static Log logger = LogFactory.getLog(ClassMgtService.class);

    @Autowired
    private ClassMgtServiceDao classMgtServiceDao;

    public Long getClassId(Long collegeId, String name) throws ServiceException {
        try {

            Long classId = classMgtServiceDao.queryClassId(collegeId, name);

            if (classId == null || classId == 0) {
                logger.info("classId不存在, 创建classId");
                classMgtServiceDao.insertClassEntity(collegeId, name);
                classId = classMgtServiceDao.insertClassEntity(collegeId, name);
            }
            return classId;
        } catch (Exception exp) {
            logger.error("获取/创建class记录失败!!!");
            throw ExceptionConstants.ACCEESS_DB_EXCEPTION;
        }
    }
}
