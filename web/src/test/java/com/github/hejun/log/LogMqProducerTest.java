package com.github.hejun.log;

import com.github.hejun.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class LogMqProducerTest extends BaseTest {

    @Autowired
    private LogMqProducer logMqProducer;

    @Test
    public void should_send_log_mq_message_successfully() throws InterruptedException {
        // given
        LogMqMessage message = new LogMqMessage();
        message.setContent("please tell me why did you do that?");
        // when
        this.logMqProducer.send(message);

        Thread.sleep(5000);

        // then
        // check the log console.
    }
}