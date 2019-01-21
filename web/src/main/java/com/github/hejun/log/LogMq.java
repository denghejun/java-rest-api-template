package com.github.hejun.log;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogMq {
    public static final String LOG_MQ_NAME = "log.mq";

    @Bean
    public ActiveMQQueue logActiveMq() {
        return new ActiveMQQueue(LOG_MQ_NAME);
    }
}
