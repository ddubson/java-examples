package com.ddubson.example.spring.jms.templated;

import com.ddubson.example.spring.jms.provider.ActiveMqJMSProvider;
import com.ddubson.example.spring.jms.provider.JMSProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

/**
 * Author: ddubson
 */
@Configuration
public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Main.class);

        context.getBean("sender", Sender.class).simpleSend();


    }

    @Bean
    public JMSProvider jmsProvider() {
        return new ActiveMqJMSProvider("tcp://localhost:61616", "mail.queue");
    }

    @Bean
    public JmsTemplate jmsTemplate() {
        return new JmsTemplate(jmsProvider().getConnectionFactory());
    }

    @Bean
    public Sender sender() {
        return new Sender(jmsTemplate(), jmsProvider());
    }

    @Bean
    public Receiver receiver() {
        return new Receiver();
    }

    @Bean
    public DefaultMessageListenerContainer jmsContainer() {
        DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
        container.setConnectionFactory(jmsProvider().getConnectionFactory());
        container.setDestination(jmsProvider().getDestination());
        container.setMessageListener(receiver());
        return container;
    }
}
