package com.im.server.service;

import com.im.server.common.ExceptionConstants;
import com.im.server.common.ServiceException;
import com.im.server.dao.DevMgtServiceDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

/**
 * Created by majun on 16/2/18.
 */

@Service
public class DevMgtService {

    private final static Log logger = LogFactory.getLog(DevMgtService.class);

    @Autowired
    private DevMgtServiceDao devMgtServiceDao;

    public void insertDev(Long pid, String dev) throws ServiceException {
        logger.info(String.format("插入设备信息, pid=%s, dev=%s", pid, dev));
        try {
            devMgtServiceDao.insertDev(pid, dev);
        } catch (DuplicateKeyException exp) {
            logger.error("数据记录已经存在", exp);
        } catch (Exception exp) {
            logger.error("数据库异常, 插入设备信息失败", exp);
            throw ExceptionConstants.ACCEESS_DB_EXCEPTION;
        }
    }

    public String getDev(Long pid) throws ServiceException {
        logger.info(String.format("获取设备信息, pid=%s", pid));
        try {
            return devMgtServiceDao.queryDev(pid);
        } catch (Exception exp) {
            logger.error("数据库异常,获取设备信息失败", exp);
            throw ExceptionConstants.ACCEESS_DB_EXCEPTION;
        }
    }


}
