package com.im.server.dao;

import org.apache.ibatis.annotations.Param;

/**
 * Created by majun on 16/3/19.
 */
public interface ClassMgtServiceDao {

    Long insertClassEntity(@Param("collegeId")Long collegeId,@Param("className") String className);

    Long queryClassId(@Param("collegeId")Long collegeId,@Param("className") String className);

}
