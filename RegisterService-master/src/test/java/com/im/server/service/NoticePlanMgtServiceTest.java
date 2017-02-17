package com.im.server.service;

import com.im.server.ServerApplication;
import com.im.server.mode.notice.ContactEntity;
import com.im.server.mode.notice.NoticeEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by majun on 16/4/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ServerApplication.class)
@WebAppConfiguration
public class NoticePlanMgtServiceTest {

    @Autowired
    private NoticePlanMgtService noticePlanMgtService;

    @Test
    public void should_ensure_read() throws Exception {
        noticePlanMgtService.ensureRead(2818669601441792l, 123456789l);
    }
    
    @Test
    public void should_get_sended_notices() throws Exception {
        List<NoticeEntity> sendedNotices = noticePlanMgtService.getSendedNotices(123456789l, 0, 10);
        for(NoticeEntity noticeEntity: sendedNotices){
            System.out.println(noticeEntity.getCreatedAt().getTime());
        }
    }

    @Test
    public void should_get_unreadPersonList() throws Exception {
        List<ContactEntity> unreadPersonList = noticePlanMgtService.getUnreadPersonList(2819132484700160l);
        System.out.println(unreadPersonList);
    }





}