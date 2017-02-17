package com.im.server.service;

import com.google.common.collect.Lists;
import com.im.server.common.ServiceException;
import com.im.server.mode.ContactEntity;
import com.im.server.mode.NoticePlan;
import com.im.server.mode.paramter.Receivers;
import com.im.server.mode.paramter.Sender;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by majun on 16/1/21.
 */
@Service
public class NoticePlanCreateService {

    private final static Log logger = LogFactory.getLog(NoticePlanCreateService.class);

    @Autowired
    private PersonMgtService studentMgtService;

    public List<NoticePlan> create(Long noticeId, Sender sender, Receivers receivers, String title, String des) {
        ArrayList<NoticePlan> noticePlans = Lists.newArrayList();

        ContactEntity assistant = receivers.getAssistant();

        if (assistant != null) {
            noticePlans.add(getNoticePlan(noticeId, sender, assistant.getName(), assistant.getPid(), title, des));
        }

        List<Long> classIds = receivers.getClassIds();

        if (classIds != null && !classIds.isEmpty()) {
            try {
                List<ContactEntity> students = studentMgtService.getStudents(classIds);
                noticePlans.addAll(getNoticePlans(noticeId, sender, students, title, des));
            } catch (ServiceException e) {
                logger.error(String.format("调用数据库根据班级id获取学生列表失败, %s", e.getMessage()));
            }
        }
        List<ContactEntity> students = receivers.getStudents();
        if (students != null && !students.isEmpty()) {
            //根据pid获取人员的信息
            noticePlans.addAll(getNoticePlans(noticeId, sender, students, title, des));
        }
        return noticePlans;
    }

    private List<NoticePlan> getNoticePlans(Long noticeId, Sender sender, List<ContactEntity> contactEntities, String title, String des) {
        return contactEntities.stream()
                .map(contactEntity -> getNoticePlan(noticeId, sender, contactEntity.getName(), contactEntity.getPid(), title, des))
                .collect(Collectors.toList());
    }

    private NoticePlan getNoticePlan(Long noticeId, Sender sender, String recvName, Long recvPid, String title, String des) {

        return new NoticePlan()
                .setNoticeId(noticeId)
                .setRecvName(recvName)
                .setRecvPid(recvPid)
                .setSenderName(sender.getName())
                .setSenderPid(sender.getPid())
                .setDes(des)
                .setTitle(title);
    }


}
