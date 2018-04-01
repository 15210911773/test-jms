package com.jms.testjms.consumer;

import com.jms.testjms.common.JmsConstant;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@Component
public class ConsumerMessageListener {

    @JmsListener(destination = JmsConstant.springQueueName)
    public void receiveQueue(String message) {
        System.err.println("接收请求:" + message);
    }

}
