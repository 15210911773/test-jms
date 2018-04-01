package com.jms.testjms.spring.jms;

import com.jms.testjms.common.JmsConstant;
import com.jms.testjms.producer.ProducerService;
import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.Destination;
import javax.jms.MessageNotWriteableException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JmsTest {

    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    private ProducerService producerService;

    @Test
    public void produce() throws MessageNotWriteableException {
        Destination destination = new ActiveMQQueue(JmsConstant.springQueueName);

        for (int i = 0; i < 100; i++) {
            producerService.sendMessage(destination, "test" + i);
            System.err.println("发送请求:" + "test" + i);
        }

    }

    @Test
    public void start() throws InterruptedException {
        Thread.sleep(10000);
    }

}
