package com.jms.testjms.producer;

import javax.jms.Destination;
import javax.jms.MessageNotWriteableException;

public interface ProducerService {

    public void test2();

    public void sendMessage(Destination destination, String msg) throws MessageNotWriteableException;

}
