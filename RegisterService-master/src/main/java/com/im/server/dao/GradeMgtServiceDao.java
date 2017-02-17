package com.im.server.dao;

import org.apache.ibatis.annotations.Param;

/**
 * Created by majun on 16/3/19.
 */
public interface GradeMgtServiceDao {

    Long insertGradeEntity(@Param("univId") Long univId, @Param("gradeName") String gradeName);

    Long queryGradeId(@Param("collegeId") Long collegeId, @Param("gradeName") String gradeName);

}
