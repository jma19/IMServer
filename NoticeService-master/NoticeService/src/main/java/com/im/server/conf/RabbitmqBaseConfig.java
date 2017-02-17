package com.im.server.conf;

import com.im.server.mq.listener.NoticeEnsureReadProcessedListener;
import com.im.server.mq.listener.NoticeProcessedListener;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by majun on 16/1/23.
 */
@Configuration
public class RabbitmqBaseConfig {

    private final String noticeCreateQueueName = "com.im.server.notice.create";
    private final String ensureReadQueueName = "com.im.server.notice.ensure.read";

    @Bean(name = "noticeCreateQueue")
    public Queue getNoticeCreateQueue() {
        return new Queue(noticeCreateQueueName, true, false, false);
    }

    @Bean(name = "ensureReadQueue")
    public Queue getEnsureReadQueue() {
        return new Queue(ensureReadQueueName, true, false, false);
    }

    @Bean(name = "noticeCenter")
    public TopicExchange exchange() {
        return new TopicExchange("NoticeCenter", true, false);
    }

    @Bean
    public Binding bindingNoticeCreate(Queue noticeCreateQueue, TopicExchange noticeCenter) {
        return BindingBuilder.bind(noticeCreateQueue).to(noticeCenter).with(noticeCreateQueueName);
    }

    @Bean
    public Binding bindingNoticeEnsureRead(Queue ensureReadQueue, TopicExchange noticeCenter) {
        return BindingBuilder.bind(ensureReadQueue).to(noticeCenter).with(ensureReadQueueName);
    }

    @Bean(name="noticeProcessedMsgAdapter")
    MessageListenerAdapter noticeProcessedMsgAdapter(NoticeProcessedListener noticeProcessedListener) {
        return new MessageListenerAdapter(noticeProcessedListener);
    }

    @Bean
    SimpleMessageListenerContainer noticeCreateContainer(ConnectionFactory connectionFactory,  MessageListenerAdapter noticeProcessedMsgAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        container.setMaxConcurrentConsumers(16);
        container.setQueueNames(noticeCreateQueueName);
        container.setMessageListener(noticeProcessedMsgAdapter);
        return container;
    }

    @Bean
    public SimpleMessageListenerContainer noticeEnsureReadContainer(ConnectionFactory connectionFactory, NoticeEnsureReadProcessedListener noticeEnsureReadProcessedListener) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        container.setMaxConcurrentConsumers(16);
        container.setQueueNames(ensureReadQueueName);
        container.setMessageListener(new MessageListenerAdapter(noticeEnsureReadProcessedListener));
        return container;
    }
}
