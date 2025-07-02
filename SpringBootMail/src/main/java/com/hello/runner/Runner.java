package com.hello.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.hello.service.IService;

@Component
public class Runner implements CommandLineRunner {

	@Autowired
	private IService is;
	@Autowired
	private Environment env;
	
	@Override
	public void run(String... args) throws Exception {

		String sndr = env.getRequiredProperty("spring.mail.username");
		is.sendMail(sndr, new String[] {"vijaycpye@gmail.com"});
		
		
	}

}
