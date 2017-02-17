package com.im.server.service;

import com.im.server.common.ExceptionConstants;
import com.im.server.common.ServiceException;
import com.im.server.dao.PersonMgtServiceDao;
import com.im.server.dao.RegisterServiceDao;
import com.im.server.mode.AsstLoginEntity;
import com.im.server.mode.LoginResponse;
import com.im.server.mode.RegisterEntity;
import com.im.server.mode.StdLoginEntity;
import com.im.server.mode.paramter.LoginRequestEntity;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

/**
 * Created by majun on 16/1/28.
 * modified by JSexy on 2016/02/01
 */
@Service
public class RegisterService {
    private final static Log logger = LogFactory.getLog(RegisterService.class);

    @Autowired
    private RegisterServiceDao registerServiceDao;

    @Autowired
    private PersonMgtServiceDao personMgtServiceDao;

    public boolean isRegistered(Long pid) throws ServiceException {
        logger.info(String.format("是否已注册, pid=%s", pid));
        try {
            Integer registered = registerServiceDao.isRegistered(pid);
            return registered != null && registered > 0 ? true : false;
        } catch (Exception exp) {
            logger.error("数据库异常,查询是否已注册失败", exp);
            throw ExceptionConstants.ACCEESS_DB_EXCEPTION;
        }

    }

    public void register(RegisterEntity register) throws ServiceException {
        try {
            LoginResponse loginResponse = personMgtServiceDao.queryStuInfo(register.getPid());
            registerServiceDao.register(getRegisterEntity(loginResponse, register));
        }catch (DuplicateKeyException exp){
            logger.warn("重复插入数据");
            throw ExceptionConstants.DUPLICATE_OPERATE_EXCEPTION;

        } catch (Exception exp) {
            logger.error("数据库异常,register失败", exp);
            throw ExceptionConstants.ACCEESS_DB_EXCEPTION;
        }

    }
    private RegisterEntity getRegisterEntity(LoginResponse loginResponse, RegisterEntity register){
        return register.setName(loginResponse.getName())
                .setUnivId(loginResponse.getUnivId())
                .setCollegeId(loginResponse.getCollegeId())
                .setAssistantId(loginResponse.getAssistantId())
                .setStatus(Integer.valueOf(0));

    }
    public RegisterEntity queryRegisterInfo(Long pid) throws ServiceException {
        logger.info(String.format("查询注册信息, pid=%s", pid));
        try {
            return registerServiceDao.queryRegisterInfo(pid);
        } catch (Exception exp) {
            logger.error("数据库异常,查询注册失败", exp);
            throw ExceptionConstants.ACCEESS_DB_EXCEPTION;
        }
    }

    public void updateRegisterInfo(RegisterEntity register) throws ServiceException {
        logger.info(String.format("更新注册信息, register=%s", register));
        try {
            registerServiceDao.updateRegisterInfo(register);
        } catch (Exception exp) {
            logger.error("数据库异常,更新注册信息失败", exp);
            throw ExceptionConstants.ACCEESS_DB_EXCEPTION;
        }
    }
}
