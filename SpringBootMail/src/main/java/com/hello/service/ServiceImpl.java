package com.hello.service;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;


@Service
public class ServiceImpl implements IService {
	@Autowired
	private JavaMailSender jms;
	
	public String sendMail(String fromMail,String[] toMail) throws MessagingException {
		MimeMessage msg = jms.createMimeMessage();
		MimeMessageHelper mmh = new MimeMessageHelper(msg,true);
		mmh.setFrom(fromMail);
		mmh.setCc(toMail);
		mmh.setSentDate(new Date());
		mmh.setText("""
				
				<h1 style="color:yellow">hi<h1>
				
				""",true);
		
		mmh.addAttachment("WIN_20250619_08_57_58_Pro.jpg",new ClassPathResource("WIN_20250619_08_57_58_Pro.jpg"));
		jms.send(msg);
		return "sent";
	}
}
