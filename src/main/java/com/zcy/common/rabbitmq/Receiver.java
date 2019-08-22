package com.zcy.common.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Description 消息消费者
 * @author:caiyuan
 * @date:2019/8/15 0015
 * @ver:1.0
 **/
@RabbitListener(queues = "hello")
@Component
public class Receiver {

    @RabbitHandler
    public void handler(String content){
        System.out.println("content:"+content);
    }
}
