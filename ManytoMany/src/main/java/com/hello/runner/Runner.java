package com.hello.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hello.entity.Applicant;
import com.hello.entity.Application;
import com.hello.service.IService;

@Component
public class Runner implements CommandLineRunner {

	@Autowired
	private IService is;
	
	@Override
	public void run(String... args) throws Exception {

		Applicant p1 = new Applicant("chinnu","chinnu7j@gmail.com");
		Applicant p2 = new Applicant("virat","kohli@gmail.com");
		Applicant p3 = new Applicant("bumarh","bumrah@gmail.com");
		Applicant p4 = new Applicant("rohit","rohit@gmail.com");
		is.register(p3,"mi");
		is.register(p4,"mi");
		
	}

}
