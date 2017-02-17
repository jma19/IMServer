package com.im.server.service;

import com.im.server.common.ExceptionConstants;
import com.im.server.common.ServiceException;
import com.im.server.dao.LoginServiceDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by majun on 16/3/1.
 */
@Service
public class LoginService {

    private final static Log logger = LogFactory.getLog(LoginService.class);

    @Autowired
    private LoginServiceDao loginServiceDao;

    public void insertLoginEntity(Long pid, String phone, String pwd) throws ServiceException {
        try {
            loginServiceDao.insertLoginEntity(pid, phone, pwd);
        } catch (Exception exp) {
            logger.error(String.format("访问数据库插入loginEntity失败 pid = %s, phone=%s,pwd=%s", pid, phone, pwd), exp);
            throw ExceptionConstants.ACCEESS_DB_EXCEPTION;
        }
    }

    public boolean isExist(String phone, String pwd) throws ServiceException {
        try {
            Integer value = loginServiceDao.exist(phone, pwd);
            return value != null && value > 0;
        } catch (Exception exp) {
            logger.error(String.format("访问数据库判断登陆信息失败phone=%s,pwd=%s", phone, pwd), exp);
            throw ExceptionConstants.ACCEESS_DB_EXCEPTION;
        }
    }

    public String getPWD(String phone) throws ServiceException {

        try {
            return loginServiceDao.queryPWd(phone);
        } catch (Exception exp) {
            logger.error(String.format("访问数据库获取密码失败, phone=%s", phone), exp);
            throw ExceptionConstants.ACCEESS_DB_EXCEPTION;
        }
    }

}

