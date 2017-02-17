package com.im.server.service.sender;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

/**
 * Created by majun on 16/1/20.
 */
@Service
public class NoticeRequestMsgSender extends SendMessageService {

    private final static Log logger = LogFactory.getLog(NoticeRequestMsgSender.class);

    private static final String routingKey = "com.im.server.notice.create";

    public void sendMessage(Object message) {
        logger.info(String.format("发送notice create消息 obj=%s", message));
        sendAsyMessage(routingKey, message);
    }
}
