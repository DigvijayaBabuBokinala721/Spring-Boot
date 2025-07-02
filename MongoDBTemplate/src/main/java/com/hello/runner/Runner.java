package com.hello.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hello.document.Product;
import com.hello.service.IserviceImpl;

@Component
public class Runner implements CommandLineRunner {

	@Autowired
	private IserviceImpl is;
	
	@Override
	public void run(String... args) throws Exception {

		Product p1 = new Product("hp laptop",60_000.);
		
		
//		System.out.println(is.register(p1));
		is.m();
		
		
	}

}
