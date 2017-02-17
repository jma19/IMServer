package com.im.server.mq.listener;

import com.im.server.common.Constants;
import com.im.server.common.ServiceException;
import com.im.server.mode.NoticePlan;
import com.im.server.mode.paramter.NoticeBody;
import com.im.server.mode.paramter.SendNoticeRequestEntity;
import com.im.server.service.IdWorkerService;
import com.im.server.service.NoticeMgtService;
import com.im.server.service.NoticePlanMgtService;
import com.im.server.service.sender.NoticePlanCreateMsgSender;
import com.im.server.service.NoticePlanCreateService;
import com.im.server.utils.JsonUtils;
import com.rabbitmq.client.Channel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by majun on 16/1/20.
 */
@Component("noticeProcessedListener")
public class NoticeProcessedListener implements ChannelAwareMessageListener {

    private static Log logger = LogFactory.getLog(NoticeProcessedListener.class);

    @Autowired
    private NoticePlanCreateService noticePlanCreateService;

    @Autowired
    private NoticeMgtService noticeMgtService;

    @Autowired
    private IdWorkerService idWorkerService;

    @Autowired
    private NoticePlanMgtService noticePlanMgtService;

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {

        String jsonMessage = new String(message.getBody());
        try {
            logger.info(String.format("NoticeProcessedListener收到数据:%s", jsonMessage));
            SendNoticeRequestEntity sendNoticesRequestEntity = JsonUtils.toObject(jsonMessage, SendNoticeRequestEntity.class);
            logger.info(String.format("NoticeProcessedListener解析数据,SendNoticeRequestEntity =%s", sendNoticesRequestEntity));
            long noticeId = idWorkerService.nextId();

            NoticeBody noticeBody = sendNoticesRequestEntity.getNoticeBody();
            noticeMgtService.insertNotice(noticeBody.setNoticeId(noticeId).setDescription(getDesText(noticeBody.getContent())));

            List<NoticePlan> noticePlans = noticePlanCreateService.create(noticeId, sendNoticesRequestEntity.getSender(), sendNoticesRequestEntity.getReceivers(), noticeBody.getTitle(), noticeBody.getDescription());

            noticePlanMgtService.insertNoticePlans(noticePlans);
            logger.info("批量写入noticePlan成功");
        } catch (ServiceException exp) {
            logger.error("数据库异常, notice处理消息失败", exp);
        } catch (Exception exp) {
            logger.error("notice消息处理失败", exp);
        } finally {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        }

    }

    private String getDesText(String msg) {
        return msg.length() <= Constants.DES_TEXT_LENGTH ? msg : msg.substring(0, Constants.DES_TEXT_LENGTH) + "...";
    }
}


