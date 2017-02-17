package com.im.server.api;

import com.im.server.common.Constants;
import com.im.server.common.ExceptionConstants;
import com.im.server.common.ServiceException;
import com.im.server.mode.RegisterEntity;
import com.im.server.mode.Response;
import com.im.server.mode.paramter.LoginRequestEntity;
import com.im.server.service.*;
import com.im.server.utils.ParamerChecker;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.im.server.common.Constants.ERROR_CODE.SYSTEM_ERROR;
import static com.im.server.common.Constants.Status.ERROR;
import static com.im.server.common.Constants.Status.SUCCESS;
import static com.im.server.utils.ParamerChecker.isNull;

/**
 * modified by JSexy on 2016/2/1
 */
@RestController
@RequestMapping("/register/service")
public class RegisterCenterService {

    private Log logger = LogFactory.getLog(RegisterCenterService.class);

    @Autowired
    private RegisterService registerSevice;

    @RequestMapping(path = "/isRegistered/{identify}/{pid}", method = RequestMethod.GET)
    public Response isRegistered(@PathVariable Long pid) {
        //学生判断是否注册, 辅导员判断是否填写过报到时间
        logger.info(String.format("isRegistered方法收到请求数据, pid=%s", pid));
        try {
            return Response.success(registerSevice.isRegistered(pid));
        } catch (Exception exp) {
            logger.error("数据库异常, 调用isRegistered接口失败", exp);
            return Response.fail("操作失败, 请重试, ERROR_CODE = ACCESS_DB_ERROR");
        }
    }

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public Response register(@RequestBody RegisterEntity register) {

        if (isNull(register) || isNull(register.getPid())
                || isNull(register.getPreStartTime()) || isNull(register.getPreArriveTime())
                || isNull(register.getTransType())) {
            return Response.fail(ExceptionConstants.ILLEGAL_PARAMETER_EXCEPTION.getMessage());
        }

        logger.info(String.format("register方法收到请求数据, register=%s", register));
        try {
            registerSevice.register(register);
        } catch (ServiceException exp) {
            if(exp.getCode().equals(ExceptionConstants.DUPLICATE_OPERATE_EXCEPTION.getCode())){
                return Response.fail(exp.getMessage());
            }
            logger.error("数据库异常, 调用register接口失败", exp);
            return Response.fail("操作失败, 请重试, ERROR_CODE = ACCESS_DB_ERROR");
        }
        return Response.success("数据保存成功");
    }


    @RequestMapping(path = "/getRegisterInfo/{pid}", method = RequestMethod.GET)
    public Response getRegisterInfo(@PathVariable Long pid) {
        logger.info(String.format("getRegisterInfo方法收到请求数据, pid=%s", pid));
        Response response = new Response();
        try {
            RegisterEntity entity = registerSevice.queryRegisterInfo(pid);
            response.setStatus(SUCCESS).setData(entity.setRemark(Constants.registerStatusMap.get(entity.getStatus())));
        } catch (ServiceException exp) {
            logger.error("数据库异常, 调用register接口失败", exp);
        }
        return response;
    }

    @RequestMapping(path = "/updateRegisterInfo", method = RequestMethod.POST)
    public Response updateRegisterInfo(@RequestBody RegisterEntity register) {
        logger.info(String.format("updateRegisterInfo方法收到请求数据, register=%s", register));
        try {
            registerSevice.updateRegisterInfo(register);
            return Response.success("操作成功");
        } catch (ServiceException exp) {
            logger.error("数据库异常, 调用updateRegisterInfo接口失败", exp);
            return Response.fail("操作失败, 请重试, ERROR_CODE = ACCESS_DB_ERROR");
        }
    }





}