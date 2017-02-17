package com.im.server.dao;

import com.im.server.mode.ClassInfo;
import com.im.server.mode.ContactEntity;
import com.im.server.mode.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by majun on 16/1/23. 需要设计人员类型的表
 */
public interface PersonMgtServiceDao {

    //根据班级获取班级中的所有学生
    List<ContactEntity> queryStuContactListOfSameAssistant(List<Long> classId);

    //获取pid同班同学
    List<ContactEntity> queryStuContactListOfSameClass(Long pid);

    //获取pid的同年级同学
    List<ContactEntity> queryStuContactListOfSameGrade(Long pid);

    //获取辅导员的联系班级
    List<ClassInfo> queryClassInfoByAssistantId(Long assistantId);

    //获取pid的同年级同学
    List<ContactEntity> queryStuContactListOfSameUniv(Long pid);

    //获取学生对应的辅导员信息
    List<ContactEntity> queryAssistant(Long pid);

    //获取辅导员管理的所有学生
    List<ContactEntity> queryStuContactListOfSameAssistant(Long assistantId);

    //获取学生所在班级的信息
    ContactEntity queryGroupInfoByPid(Long pid);

    Student queryStudent(Long pid);

    //获取classId
    Long queryClassId(Long pid);

    //获取collegeId
    Long queryCollegeId(Long pid);

    //获取GradeId
    Long queryGradeId(Long pid);

    //univId
    Long queryUnivId(Long pid);

    void insertStudentHeadPicUrl(@Param("pid") Long pid, @Param("headUrl") String headUrl);

    void insertAssistantHeadPicUrl(@Param("pid") Long pid, @Param("headUrl") String headUrl);
    
}
