package com.im.server.dao;

import org.apache.ibatis.annotations.Param;

/**
 * Created by majun on 16/2/18.
 */
public interface DevMgtServiceDao {

    void insertDev(@Param("pid") Long pid, @Param("Dev") String dev);

    String queryDev(Long pid);
}
