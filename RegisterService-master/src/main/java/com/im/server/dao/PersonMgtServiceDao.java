package com.im.server.dao;


import com.im.server.mode.ClassInfo;
import com.im.server.mode.GroupInfo;
import com.im.server.mode.LoginResponse;
import com.im.server.mode.db.Student;
import com.im.server.mode.notice.ContactEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by majun on 16/3/1.
 */
public interface PersonMgtServiceDao {

    Long queryStudentPid(String phone);

    Long queryAssistantPid(String phone);

    LoginResponse queryStuInfo(Long pid);

    LoginResponse queryStuInfoByPhone(String phone);

    //根据辅导员id获取辅导员的信息
    LoginResponse queryAssInfo(Long pid);

    LoginResponse queryAssInfoByPhone(String phone);


    //根据班级获取班级中的所有学生
    List<ContactEntity> queryStudentsByClassIds(List<Integer> classId);

    //获取pid同班同学
    List<ContactEntity> queryStuContactListOfSameClass(Long pid);

    //获取pid的同年级同学
    List<ContactEntity> queryStuContactListOfSameGrade(Long pid);

    //获取辅导员下关联的所有学生列表
    List<ContactEntity> queryStudentsByAssistantId(Long assistantId);

    //获取辅导员的联系班级
    List<GroupInfo> queryClassInfoByAssistantId(Long assistantId);

    //获取pid的同年级同学
    List<ContactEntity> queryStuContactListOfSameUniv(Long pid);

    //获取pid的同学同学
    List<ContactEntity> queryStuContactListOfSameCollege(Long pid);

    //获取学生对应的辅导员信息
    List<ContactEntity> queryAssistant(Long pid);

    //获取辅导员管理的所有学生
    List<ContactEntity> queryStudentsByClassIds(Long assistantId);

    GroupInfo queryGroupInfoByStudentPid(Long pid);

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