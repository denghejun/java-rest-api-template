package com.github.hejun.log;

import com.github.hejun.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class LogMqConsumer {

    @JmsListener(destination = LogMq.LOG_MQ_NAME)
    public void consume(String messageJson) {
        try {
            LogMqMessage message = JsonUtil.toObject(messageJson, LogMqMessage.class);
            log.info("Log MQ message has been consumed successfully: " + message.getContent());
        } catch (IOException e) {
            log.error("consume log mq message failed.", e);
        }
    }
}
