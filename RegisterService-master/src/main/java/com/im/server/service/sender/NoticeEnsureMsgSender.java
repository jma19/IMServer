package com.im.server.service.sender;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

/**
 * Created by majun on 16/1/22.
 */
@Service
public class NoticeEnsureMsgSender extends SendMessageService {
    private final static Log logger = LogFactory.getLog(com.im.server.service.sender.NoticeEnsureMsgSender.class);

    private static final String routingKey = "com.im.server.notice.ensure.read";

    public void sendMessage(Object message) {
        logger.info(String.format("发送notice ensure消息obj=%s", message));
        sendAsyMessage(routingKey, message);
    }
}
