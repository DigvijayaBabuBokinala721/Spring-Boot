package com.hello.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hello.entity.Aadhaar;
import com.hello.entity.BankAccount;
import com.hello.entity.Person;
import com.hello.service.IpersonService;

@Component
public class Runner implements CommandLineRunner {

	@Autowired
	private IpersonService ipersonService;
	
	@Override
	public void run(String... args) throws Exception {
		
		Aadhaar aadhaar = new Aadhaar(766170001234l); //Person's Aadhaar
		BankAccount bk = new BankAccount(1_90_000.,"savings"); //person's bankaccount
		Person person1 = new Person("Digvijay","chinnu7j@gmail.com",aadhaar,List.of(bk)); //creating person's object
		bk.setPerson(person1);
		aadhaar.setPerson(person1);
		
		
//		ipersonService.register(person1);
		
//		ipersonService.withdraw(123712, 90_000.);
		
		ipersonService.deposit(123712, 20_000.);
	}

}
