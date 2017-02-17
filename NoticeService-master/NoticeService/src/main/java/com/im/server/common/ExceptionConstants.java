package com.im.server.common;

/**
 * Created by majun on 16/1/21.
 */
public interface ExceptionConstants {

    ServiceException ILLEGAL_PARAMETER_EXCEPTION = new ServiceException("ILLEGAL_PARAMETERS_ERROR", "参数校验失败!!!");
    ServiceException ACCEESS_DB_EXCEPTION = new ServiceException("SYSTEM_ERROR", "访问数据异常");

}
