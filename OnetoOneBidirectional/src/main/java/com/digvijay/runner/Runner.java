package com.digvijay.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.digvijay.entity.PANCard;
import com.digvijay.entity.Person;
import com.digvijay.service.IPANService;
import com.digvijay.service.IpersonService;


@Component
public class Runner implements CommandLineRunner {

	@Autowired
	private IpersonService personService;
	
	@Autowired
	private IPANService panService;
	
	@Override
	public void run(String... args) throws Exception {
		
		PANCard pan1 = new PANCard("123d321");
		
		Person person1 = new Person("Digvijay", pan1);
		
		pan1.setPerson(person1);
		
		System.out.println(personService.regiser(person1));
		
//		System.out.println(panService.register(pan1));
	}

}
