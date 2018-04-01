package com.jms.testjms.queue;

import com.jms.testjms.common.JmsConstant;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 *
 */
public class AppProducer {



    public static void main(String[] args) throws JMSException {

        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(JmsConstant.url);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue(JmsConstant.queueName);
        MessageProducer producer = session.createProducer(destination);
        for(int i = 0; i < 100; i++) {
            TextMessage textMessage = session.createTextMessage("test" + i);

            producer.send(textMessage);
            System.err.println("发送消息" + textMessage.getText());
        }

        connection.close();

    }

}
