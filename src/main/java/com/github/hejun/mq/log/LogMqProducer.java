package com.github.hejun.mq.log;

import com.github.hejun.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LogMqProducer {
    private final JmsMessagingTemplate jmsMessagingTemplate;
    private final ActiveMQQueue logMq;

    @Autowired
    public LogMqProducer(JmsMessagingTemplate jmsMessagingTemplate, ActiveMQQueue logMq) {
        this.jmsMessagingTemplate = jmsMessagingTemplate;
        this.logMq = logMq;
    }

    public void send(LogMqMessage message) {
        try {
            String json = JsonUtil.toJson(message);
            this.jmsMessagingTemplate.convertAndSend(this.logMq, json);
            log.info("produce log mq message successfully: " + json);
        } catch (Exception ex) {
            log.error("produce log mq message failed.", ex);
        }
    }
}
