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
	private IpersonService is;
	
	@Override
	public void run(String... args) throws Exception {
		
		Aadhaar aadhaar = new Aadhaar(123l);
		BankAccount bk = new BankAccount(1_90_000.,"savings");
		Person person1 = new Person("chinnu","vijaycpye@gmail.com",aadhaar,List.of(bk));
		bk.setPerson(person1);
		aadhaar.setPerson(person1);
//		is.register(person1);
		
		is.withdraw(1, 90_000.);
	}

}
