package com.im.server.mq.listener;

import com.im.server.common.ServiceException;
import com.im.server.mode.EnsureReadEntity;
import com.im.server.service.NoticePlanMgtService;
import com.im.server.utils.JsonUtils;
import com.rabbitmq.client.Channel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by majun on 16/1/22.
 */
@Component("noticeEnsureReadProcessedListener")
public class NoticeEnsureReadProcessedListener implements ChannelAwareMessageListener {

    private static Log logger = LogFactory.getLog(NoticeEnsureReadProcessedListener.class);

    @Autowired
    private NoticePlanMgtService noticePlanMgtService;

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        String jsonMessage = new String(message.getBody());

        try {
            EnsureReadEntity ensureReadEntity = JsonUtils.toObject(jsonMessage, EnsureReadEntity.class);
            noticePlanMgtService.ensureRead(ensureReadEntity.getNoticeId(), ensureReadEntity.getPid());
        } catch (ServiceException exp) {
            logger.error(String.format("数据库异常, 处理notice ensure消息失败, msg=%s", exp.getMessage()));
        } catch (Exception exp) {
            logger.error("处理notice ensure消息失败", exp);
        } finally {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        }
    }

}
