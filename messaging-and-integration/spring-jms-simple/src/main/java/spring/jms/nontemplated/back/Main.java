package com.ddubson.example.spring.jms.nontemplated.back;

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
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        BackOffice backOffice = context.getBean("backOffice", BackOffice.class);
        Mail mail = backOffice.receiveMail();
        System.out.println("Mail #" + mail.getMailId() + " received.");
    }

    @Bean
    public JMSProvider jmsProvider() {
        return new ActiveMqJMSProvider("tcp://localhost:61616", "mail.queue");
    }

    @Bean
    public BackOffice backOffice() {
        return new BackOfficeConsumer(jmsProvider());
    }
}
