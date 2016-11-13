package com.ddubson.example.spring.jms.templated;

import com.ddubson.example.spring.jms.provider.JMSProvider;
import org.springframework.jms.core.JmsTemplate;

/**
 * Author: ddubson
 */
public class Sender {
    private final JMSProvider provider;
    private final JmsTemplate jmsTemplate;

    public Sender(JmsTemplate jmsTemplate, JMSProvider provider) {
        this.jmsTemplate = jmsTemplate;
        this.provider = provider;
    }

    public void simpleSend() {
        this.jmsTemplate.send(this.provider.getDestination(), session -> session.createTextMessage("hello queue world"));
    }
}
