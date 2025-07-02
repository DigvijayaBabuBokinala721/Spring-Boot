package com.hello.service;

import javax.swing.Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.hello.entity.BankAccount;
import com.hello.entity.Person;
import com.hello.repository.IBankAccountRepo;
import com.hello.repository.IPersonRepo;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class PersonServiceImpl implements IpersonService {
	
	@Autowired
	private IPersonRepo personRepo;
	
	@Autowired
	private IBankAccountRepo bankRepo;
	
	@Autowired
	private JavaMailSender jms;
	
	@Autowired
	private Environment env;
	
	@Override
	public String register(Person p) throws MessagingException {
		personRepo.save(p);
		sendMail(p.getEmail(),"account creation", " dear " + p.getName() + " ur account has been created");
		return "successful";
	}
	
	


	@Override
	public double withdraw(long accNo,double amt) throws MessagingException {
		
		BankAccount bankAccount = bankRepo.findById(accNo).get();
		double currentBalance = bankAccount.getBalance();
		double remainingBalance = currentBalance - amt;
		bankAccount.setBalance(remainingBalance);
		bankRepo.save(bankAccount);
		sendMail(bankAccount.getPerson().getEmail(), "withdraw", " amt withdrawn " + amt + " remaining balance " + remainingBalance);
		
		return amt;
	}

	private void sendMail(String tomail,String sub,String msg) throws MessagingException {
		
		MimeMessage mm =  jms.createMimeMessage();
		MimeMessageHelper mmh = new MimeMessageHelper(mm,true);
		mmh.setCc(tomail);
		mmh.setFrom(env.getRequiredProperty("spring.mail.username"));
		mmh.setText(msg);
		mmh.setSubject(sub);
		jms.send(mm);
	}


}
