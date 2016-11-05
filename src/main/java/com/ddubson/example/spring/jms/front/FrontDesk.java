package com.ddubson.example.spring.jms.front;


import com.ddubson.example.spring.jms.Mail;
import org.springframework.stereotype.Component;

@Component
public interface FrontDesk {
	public void sendMail(Mail mail);
}
