package com.ddubson.example.spring.jms.templated;

import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * Author: ddubson
 */
public class Receiver implements MessageListener{
    @Override
    public void onMessage(Message message) {
        System.out.println("Received msg: " + message.toString());
    }
}
