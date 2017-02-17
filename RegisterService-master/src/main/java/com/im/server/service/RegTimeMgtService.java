package com.im.server.service;

import com.im.server.common.Constants;
import com.im.server.common.ExceptionConstants;
import com.im.server.common.ServiceException;
import com.im.server.dao.RegTimeMgtServiceDao;
import com.im.server.mode.db.RegTime;
import com.im.server.mode.notice.ContactEntity;
import com.im.server.mode.paramter.*;
import com.im.server.service.sender.NoticeRequestMsgSender;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by majun on 16/3/5.
 */
@Service
public class RegTimeMgtService {

    private final static Log logger = LogFactory.getLog(RegTimeMgtService.class);

    @Autowired
    private RegTimeMgtServiceDao regTimeMgtServiceDao;

    @Autowired
    private PersonMgtService personMgtService;

    @Autowired
    private NoticeRequestMsgSender noticeRequestService;

    public void createRegTimeEntity(RegTimeEntity regTimeEntity) throws ServiceException {
        try {
            RegTime regTime = getRegTime(regTimeEntity);
            regTimeMgtServiceDao.createRegTimeEntity(regTime);
            //索引出当前辅导员所有的学生, 然后广播通知
            //获取当前辅导员所有的学生
            List<ContactEntity> studentsByAssistantId = personMgtService.getStudentsByAssistantId(regTime.getPid());
            SendNoticeRequestEntity message = new SendNoticeRequestEntity()
                    .setNoticeBody(new NoticeBody().setContent(regTime.getDetail()).setTitle("报到细节通知"))
                    .setSender(new ContactEntity().setName(regTime.getName()).setPid(regTime.getPid()).setType(Constants.Identify.assistant))
                    .setReceivers(new Receivers().setStudents(studentsByAssistantId));
            noticeRequestService.sendMessage(message);
        } catch (DuplicateKeyException exp) {
            throw ExceptionConstants.DUPLICATE_OPERATE_EXCEPTION;
        } catch (Exception exp) {
            logger.error("数据库异常,插入报名时间失败", exp);
            throw ExceptionConstants.ACCEESS_DB_EXCEPTION;
        }
    }

    private RegTime getRegTime(RegTimeEntity regTimeEntity) {
        return new RegTime().setEndAt(regTimeEntity.getEndAt())
                .setStartAt(regTimeEntity.getStartAt())
                .setPid(regTimeEntity.getPid())
                .setId(regTimeEntity.getId())
                .setIsValid(regTimeEntity.getIsValid())
                .setDetail(regTimeEntity.getDetail())
                .setName(regTimeEntity.getName());
    }

    private RegTimeEntity getRegTimeEntity(RegTime regTime) {
        return new RegTimeEntity().setEndAt(regTime.getEndAt())
                .setStartAt(regTime.getStartAt())
                .setId(regTime.getId())
                .setIsValid(regTime.getIsValid())
                .setPid(regTime.getPid())
                .setDetail(regTime.getDetail())
                .setName(regTime.getName());
    }


    public RegTimeEntity getRegTimeEntity(Long pid, Integer identify) throws ServiceException {
        //根据pid获取
        //学生的pid
        //学生
//        if (identify == Constants.Identify.student) {
//            //根据学生的id 获取assistantId
//            LoginResponse perInfo = personMgtService.getPerInfo(pid, identify);
//            pid = perInfo.getAssistantId();
//
//        }
        try {
            RegTime regTime = regTimeMgtServiceDao.queryTimeEntity(pid);
            return getRegTimeEntity(regTime);
        } catch (Exception exp) {
            logger.error("数据库异常,插入报名时间失败", exp);
            throw ExceptionConstants.ACCEESS_DB_EXCEPTION;
        }
    }
}
