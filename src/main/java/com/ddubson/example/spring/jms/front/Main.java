package com.ddubson.example.spring.jms.front;


import com.ddubson.example.spring.jms.Mail;
import com.ddubson.example.spring.jms.provider.ActiveMqJMSProvider;
import com.ddubson.example.spring.jms.provider.JMSProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Main.class);
        context.getBean("frontDesk", FrontDesk.class).sendMail(new Mail("1234", "US", 1.5));
        System.out.println("Mail sent.");

    }

    @Bean
    public JMSProvider jmsProvider() {
        return new ActiveMqJMSProvider("tcp://localhost:61616", "mail.queue");
    }

    @Bean
    public FrontDesk frontDesk() {
        return new FrontDeskProducer(jmsProvider());
    }
}
