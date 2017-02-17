package com.im.server.api;

import com.google.common.collect.Lists;
import com.im.server.ServerApplication;
import com.im.server.mode.ContactEntity;
import com.im.server.mode.EnsureReadEntity;
import com.im.server.mode.Response;
import com.im.server.mode.paramter.NoticeBody;
import com.im.server.mode.paramter.Receivers;
import com.im.server.mode.paramter.SendNoticeRequestEntity;
import com.im.server.mode.paramter.Sender;
import com.im.server.utils.JsonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.UUID;

import static org.junit.Assert.*;

/**
 * Created by majun on 16/1/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ServerApplication.class)
@WebAppConfiguration
public class NoticeCenterServiceTest {

    @Autowired
    private NoticeCenterService noticeCenterService;

    @Test
    public void testSendNotice() throws Exception {
        Receivers receivers = getReceivers();
        SendNoticeRequestEntity sendNoticesRequestEntity = new SendNoticeRequestEntity()
                .setSender(new Sender().setName("xiaoya").setPid(2l))
                .setReceivers(receivers)
                .setNoticeBody(new NoticeBody().setTitle("I have a dream").setContent("I have a dream, test"));
        System.out.println(JsonUtils.toJson(sendNoticesRequestEntity));
//        noticeCenterService.sendNoticesRequestEntitye(sendNoticesRequestEntityeestEntity);
    }

    private Receivers getReceivers() {
        ContactEntity contactEntity1 = new ContactEntity().setName("Test").setPid(2l);
        ContactEntity contactEntity2 = new ContactEntity().setName("Test").setPid(3l);
        ContactEntity contactEntity3 = new ContactEntity().setName("Test").setPid(4l);

        return new Receivers().setStudents(Lists.newArrayList(contactEntity1, contactEntity2, contactEntity3));
    }

    @Test
    public void testEnsureRead() throws Exception {
        noticeCenterService.ensureRead(new EnsureReadEntity().setNoticeId(2698920962820096l).setPid(3l));
    }

}