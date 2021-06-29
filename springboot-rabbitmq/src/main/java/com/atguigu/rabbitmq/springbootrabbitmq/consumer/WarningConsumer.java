package com.atguigu.rabbitmq.springbootrabbitmq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.atguigu.rabbitmq.springbootrabbitmq.config.ConfirmConfig.WARNING_QUEUE_NAME;

@Component
@Slf4j
public class WarningConsumer {
    //接收报警消息
    @RabbitListener(queues = WARNING_QUEUE_NAME)
    public void receiveWarningMsg(Message message) {
        String msg = new String(message.getBody());
        log.error("报警发现不可路由消息：{}", msg);
    }
}
