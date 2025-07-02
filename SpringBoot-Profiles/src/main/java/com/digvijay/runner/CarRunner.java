package com.digvijay.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.digvijay.sbeans.Car;


@Component
public class CarRunner implements CommandLineRunner {

	@Autowired
	private Car car;
	
	@Override
	public void run(String... args) throws Exception {

		car.ignite();
		
	}

}
