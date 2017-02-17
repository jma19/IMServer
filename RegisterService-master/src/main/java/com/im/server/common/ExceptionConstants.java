package com.im.server.common;

/**
 * Created by majun on 16/1/21.
 */
public interface  ExceptionConstants {

    ServiceException ILLEGAL_PARAMETER_EXCEPTION = new ServiceException("ILLEGAL_PARAMETERS_ERROR", "输入参数有误!!!");
    ServiceException ALREADY_FEEDBACK_EXCEPTION = new ServiceException("ALREADY_FEEDBACK_ERROR", "参数不合法");

    ServiceException ACCEESS_DB_EXCEPTION = new ServiceException("SYSTEM_ERROR", "访问数据异常");
    ServiceException DUPLICATE_OPERATE_EXCEPTION = new ServiceException("DUPLICATE_ERROR", "操作已成功,请勿重复操作!!");
    ServiceException UNKNOWN_EXCEPTION = new ServiceException("UNKNOWN_ERROR", "未知异常");

    ServiceException SEND_VALIDATE_CPDE_EXCEPTION = new ServiceException("SEND_VALIDATE_CODE_ERROR", "发送验证码异常");

}
