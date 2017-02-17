package com.im.server.service;

import com.im.server.common.ExceptionConstants;
import com.im.server.common.ServiceException;
import com.im.server.dao.CollegeMgtServiceDao;
import com.im.server.mode.db.College;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by majun on 16/3/4.
 */
@Service
public class CollegeMgtService {

    private final static Log logger = LogFactory.getLog(CollegeMgtService.class);

    @Autowired
    private CollegeMgtServiceDao collegeMgtServiceDao;

    public void createCollegeEntity(College college) throws ServiceException {
        try {
            collegeMgtServiceDao.createCollegeEntity(college);
        }catch (Exception exp){
            logger.error("数据库异常,插入学院信息失败", exp);
            throw ExceptionConstants.ACCEESS_DB_EXCEPTION;
        }
    }

    public List<College> getCollegeEntities(String univName) throws ServiceException {
        try {
            return collegeMgtServiceDao.queryCollegeEntities(univName);
        }catch (Exception exp){
            logger.error("数据库异常, 获取学院信息失败", exp);
            throw ExceptionConstants.ACCEESS_DB_EXCEPTION;
        }
    }

    public Long  getCollegeId(Long univId, String collegeName) throws ServiceException {
        try {
            return collegeMgtServiceDao.queryCollegeId(univId, collegeName);
        }catch (Exception exp){
            logger.error("数据库异常, 获取学院id失败", exp);
            throw ExceptionConstants.ACCEESS_DB_EXCEPTION;
        }
    }

}
