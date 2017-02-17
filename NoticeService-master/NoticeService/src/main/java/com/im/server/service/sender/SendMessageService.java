package com.im.server.service.sender;

import com.im.server.utils.JsonUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by majun on 16/1/20.
 */
public abstract class SendMessageService {
    private static Log logger = LogFactory.getLog(SendMessageService.class);

    @Autowired
    private RabbitTemplate amqpTemplate;

    public void sendAsyMessage(String routingKey, Object object) {
        try {
            amqpTemplate.convertAndSend(routingKey, JsonUtils.toJson(object));
        } catch (Exception exp) {
            logger.error("发送数据失败!!!", exp);
        }
    }

}
