package com.digvijay.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties("car")
@Data
public class Car {
	
	@Autowired
	private Engine engine;
	
	private String driver;
	
	
	public void ignite() {
		engine.start();
		System.out.println(driver + " driving the car");
	}
	
	public void turnOffEngine() {
		engine.stop();
	}
	
}
