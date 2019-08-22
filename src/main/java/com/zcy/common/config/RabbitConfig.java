package com.zcy.common.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description RabbitMQ 配置类
 * @author:caiyuan
 * @date:2019/8/15 0015
 * @ver:1.0
 **/
@Configuration
public class RabbitConfig {

    @Bean
    public Queue helloQueue(){
        return new Queue("hello");
    }
}
