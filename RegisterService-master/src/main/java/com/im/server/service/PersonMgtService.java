package com.im.server.service;

import com.google.common.collect.Lists;
import com.im.server.common.Constants;
import com.im.server.common.ExceptionConstants;
import com.im.server.common.ServiceException;
import com.im.server.dao.PersonMgtServiceDao;
import com.im.server.mode.*;
import com.im.server.mode.notice.ContactEntity;
import com.im.server.mode.notice.DivideInfo;
import com.im.server.mode.notice.Group;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by majun on 16/1/23.
 */
@Service
public class PersonMgtService {

    private final static Log logger = LogFactory.getLog(PersonMgtService.class);

    @Autowired
    private PersonMgtServiceDao personMgtServiceDao;

    @Autowired
    private AdminService adminService;

    public Long getPid(String phone, Integer identify) throws ServiceException {

        logger.info(String.format("获取pid, phone=%s, identify=%s", phone, identify));

        try {
            if (identify == Constants.Identify.student) {
                return personMgtServiceDao.queryStudentPid(phone);
            }
            return personMgtServiceDao.queryAssistantPid(phone);
        } catch (Exception exp) {
            logger.error(String.format("访问数据库获取pid失败, phone=%s,identify=%s", phone, identify), exp);
            throw ExceptionConstants.ACCEESS_DB_EXCEPTION;
        }
    }

    public LoginResponse getPerInfo(String phone, Integer identify) throws ServiceException {

        try {
            if (identify == Constants.Identify.student) {
                return personMgtServiceDao.queryStuInfoByPhone(phone);
            }
            return personMgtServiceDao.queryAssInfoByPhone(phone);
        } catch (Exception exp) {
            logger.error(String.format("queryPerInfo访问数据库获取信息失败, phone=%s, identify=%s", phone, identify), exp);
            throw ExceptionConstants.ACCEESS_DB_EXCEPTION;
        }
    }

    public LoginResponse getPerInfo(Long pid, Integer identify) throws ServiceException {

        try {
            if (identify == Constants.Identify.student) {
                return personMgtServiceDao.queryStuInfo(pid);
            }
            return personMgtServiceDao.queryAssInfo(pid);
        } catch (Exception exp) {
            logger.error(String.format("queryPerInfo访问数据库获取信息失败, pid=%s, identify=%s", pid, identify), exp);
            throw ExceptionConstants.ACCEESS_DB_EXCEPTION;
        }
    }

    public List<ContactEntity> getStudentsByClassIds(List<Integer> classIds) throws ServiceException {
        logger.info(String.format("根据班级id获取学生基本list, classId=%s", classIds));

        try {
            return personMgtServiceDao.queryStudentsByClassIds(classIds);
        } catch (Exception exp) {
            logger.error("数据库异常,getStudents失败", exp);
            throw ExceptionConstants.ACCEESS_DB_EXCEPTION;
        }
    }

    public List<ContactEntity> getStudentsByAssistantId(Long assistantId) throws ServiceException {
        logger.info(String.format("根据辅导员id获取学生list, assistantId=%s", assistantId));
        try {
            return personMgtServiceDao.queryStudentsByAssistantId(assistantId);
        } catch (Exception exp) {
            logger.error("数据库异常,getStudents失败", exp);
            throw ExceptionConstants.ACCEESS_DB_EXCEPTION;
        }
    }


    //nice
    public List<ContactEntity> getGradeStudents(Long pid) throws ServiceException {
        logger.info(String.format("获取年级student, pid=%s", pid));
        try {
            return personMgtServiceDao.queryStuContactListOfSameGrade(pid);
        } catch (Exception exp) {
            logger.error("数据库异常,getStudents失败", exp);
            throw ExceptionConstants.ACCEESS_DB_EXCEPTION;
        }
    }

    public List<ContactEntity> getCollegeStudents(Long pid) throws ServiceException {
        logger.info(String.format("获取学校student, pid=%s", pid));
        try {
            return personMgtServiceDao.queryStuContactListOfSameCollege(pid);
        } catch (Exception exp) {
            //nice
            logger.error("数据库异常,getStudents失败", exp);
            throw ExceptionConstants.ACCEESS_DB_EXCEPTION;
        }
    }

    public List<ContactEntity> getUnivStudents(Long pid) throws ServiceException {
        logger.info(String.format("获取学校student, pid=%s", pid));
        try {
            return personMgtServiceDao.queryStuContactListOfSameUniv(pid);
        } catch (Exception exp) {
            //nice
            logger.error("数据库异常,getStudents失败", exp);
            throw ExceptionConstants.ACCEESS_DB_EXCEPTION;
        }
    }


    public DivideInfo getContactInfo(Integer type, Long pid) throws ServiceException {
        //
        logger.info(String.format("获取联系人, pid=%s", type, pid));
        if (type == Constants.Identify.student) {
            try {
                List<ContactEntity> contactEntities = personMgtServiceDao.queryStuContactListOfSameClass(pid);
                System.out.println("获取contactEntities-----" + contactEntities);
                //获取班级和班级名称
                GroupInfo groupInfo = personMgtServiceDao.queryGroupInfoByStudentPid(pid);
                ContactEntity classEntity = new ContactEntity().setName(groupInfo.getClassName()).setPid(groupInfo.getClassId());
                System.out.println("获取classEntity---" + classEntity);
                //获取辅导员的信息
                //获取辅导员的姓名
                ContactEntity assistantEntity = new ContactEntity().setName(groupInfo.getAssistantName()).setPid(groupInfo.getAssistantId()).setType(Constants.Identify.assistant);
                ContactEntity adminEntity = getAdminEntity();
                return new DivideInfo().setContacts(contactEntities).setGroup(getGroup(Lists.newArrayList(classEntity), assistantEntity, adminEntity));
            } catch (Exception exp) {
                logger.error(String.format("获取联系人失败, pid=%s", pid), exp);
                throw ExceptionConstants.ACCEESS_DB_EXCEPTION;

            }

        } else if (type == Constants.Identify.assistant) {
            try {
                //此时pid为assistantId
                List<ContactEntity> contactEntities = personMgtServiceDao.queryStudentsByAssistantId(pid);
                System.out.println("获取辅导员下所有的学生list....." + contactEntities);
                Group group = getGroup(pid);
                System.out.println("获取组的信息......" + group);
                return new DivideInfo().setContacts(contactEntities).setGroup(group);
            } catch (Exception exp) {
                logger.error(String.format("根据辅导员id获取联系人失败, pid=%s", pid), exp);
                throw ExceptionConstants.ACCEESS_DB_EXCEPTION;
            }
        }
        return null;

    }

    private Group getGroup(Long pid) {
        //获取班级的数据
        List<GroupInfo> groupInfos = personMgtServiceDao.queryClassInfoByAssistantId(pid);
        //获取系统管理员账号
        System.out.println("----获取班级数据:----" + groupInfos);
        ContactEntity adminEntity = getAdminEntity();
        return getGroup(transform(groupInfos), null, adminEntity);
    }

    private List<ContactEntity> transform(List<GroupInfo> groupInfos) {

        System.out.println("wo cao " + groupInfos == null || groupInfos.isEmpty());
        System.out.println("卧槽......" + groupInfos.size() + "--------" + groupInfos.get(0));
        if (groupInfos == null || groupInfos.isEmpty()) {
            return null;
        }

        List<ContactEntity> result = Lists.newArrayList();
        for (GroupInfo classInfo : groupInfos) {
            result.add(new ContactEntity().setName(classInfo.getClassName()).setPid(classInfo.getClassId()));
        }
        return result;
    }

    private ContactEntity getAdminEntity() {
        //获取系统管理员的信息
        AdminInfo first = adminService.findFirst();
        return new ContactEntity().setName(first.getName()).setPid(first.getId());
    }

    private Group getGroup(List<ContactEntity> classEntities, ContactEntity assistant, ContactEntity admin) {
        return new Group()
                .setAdmin(admin)
                .setAssistant(assistant)
                .setClassEntities(classEntities);
    }


}
