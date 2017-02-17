/*
package com.im.server.service.sender;

import com.im.server.ServerApplication;
import com.im.server.mode.ContactEntity;
import com.im.server.utils.JsonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ServerApplication.class)
@WebAppConfiguration
public class NoticeRequestMsgSenderTest {

    @Autowired
    private NoticeRequestMsgSender noticeRequestMsgSender;

    @Test
    public void testSendMessage() throws Exception {
        noticeRequestMsgSender.sendMessage(JsonUtils.toJson(new ContactEntity().setName("majun").setPid(1l)));
        noticeRequestMsgSender.sendMessage(new ContactEntity().setName("majun").setPid(1l));

    }
}*/
