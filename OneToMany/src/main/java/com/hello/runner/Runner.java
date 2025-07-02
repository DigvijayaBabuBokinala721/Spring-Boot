package com.hello.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hello.service.IService;

@Component
public class Runner implements CommandLineRunner {

	@Autowired
	private IService is;
	
	@Override
	public void run(String... args) throws Exception {
		
		is.register();
//		is.findAll();
		
	}

}
