package com.im.server.dao;

import org.apache.ibatis.annotations.Param;

/**
 * Created by majun on 16/3/1.
 */
public interface LoginServiceDao {

    void insertLoginEntity(@Param("pid")Long pid, @Param("phone")String phone,@Param("pwd") String pwd);

    //需要创建联合索引
    Integer exist (@Param("phone") String phone, @Param("pwd") String pwd);


    String queryPWd(String phone);
}
