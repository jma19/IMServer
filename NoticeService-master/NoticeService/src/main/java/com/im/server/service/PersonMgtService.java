package com.im.server.service;

import com.google.common.collect.Lists;
import com.im.server.common.Constants;
import com.im.server.common.ExceptionConstants;
import com.im.server.common.ServiceException;
import com.im.server.dao.PersonMgtServiceDao;
import com.im.server.mode.*;
import com.im.server.mode.ClassInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by majun on 16/1/23.
 */
@Service
public class PersonMgtService {

    private final static Log logger = LogFactory.getLog(PersonMgtService.class);

    @Autowired
    private PersonMgtServiceDao studentMgtServiceDao;

    @Autowired
    private AdminService adminService;

    public List<ContactEntity> getStudents(List<Long> classIds) throws ServiceException {
        logger.info(String.format("根据班级id获取学生基本list, classId=%s", classIds));

        try {
            return studentMgtServiceDao.queryStuContactListOfSameAssistant(classIds);
        } catch (Exception exp) {
            logger.error("数据库异常,getStudents失败", exp);
            throw ExceptionConstants.ACCEESS_DB_EXCEPTION;
        }
    }

    public DivideInfo getContactInfo(Integer type, Long pid) throws ServiceException {
        //
        logger.info(String.format("获取联系人, pid=%s", type, pid));
        DivideInfo divideInfo = new DivideInfo();
        if (type == Constants.Type.STUDENT) {
            //获取班级
            try{
                List<ContactEntity> contactEntities = studentMgtServiceDao.queryStuContactListOfSameClass(pid);
                divideInfo.setContacts(contactEntities);
                //获取班级和班级名称
                Student student = studentMgtServiceDao.queryStudent(pid);
                ContactEntity classEntity = new ContactEntity().setName(student.getClassName()).setPid(student.getClassId());
                //获取辅导员的信息
                ContactEntity assistantEntity = new ContactEntity().setName(student.getAssistantName()).setPid(student.getAssistantId());
                ContactEntity adminEntity = getAdminEntity();
                divideInfo.setGroup(getGroup(Lists.newArrayList(classEntity), assistantEntity, adminEntity));
            }catch (Exception exp){
                throw ExceptionConstants.ACCEESS_DB_EXCEPTION;

            }

        } else if (type == Constants.Type.ASSISTANT) {
            try{
                //此时pid为assistantId
                List<ContactEntity> contactEntities = studentMgtServiceDao.queryStuContactListOfSameAssistant(pid);
                divideInfo.setContacts(contactEntities);
                //获取班级的数据
                List<ClassInfo> classInfos = studentMgtServiceDao.queryClassInfoByAssistantId(pid);

                //获取系统管理员账号
                ContactEntity adminEntity = getAdminEntity();

                Group group = getGroup(transform(classInfos), null, adminEntity);
                divideInfo.setContacts(contactEntities).setGroup(group);
            }catch (Exception exp){
                throw ExceptionConstants.ACCEESS_DB_EXCEPTION;
            }

        }

        return divideInfo;

    }

    private List<ContactEntity> transform(List<ClassInfo> classInfos) {
        return classInfos.stream()
                .map(classInfo -> new ContactEntity().setName(classInfo.getClassName()).setPid(classInfo.getClassId()))
                .collect(Collectors.toList());
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
