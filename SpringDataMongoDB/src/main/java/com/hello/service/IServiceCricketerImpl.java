package com.hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hello.document.Cricketer;
import com.hello.repository.ICricketerRepo;

@Service
public class IServiceCricketerImpl implements IServiceCricketer {

	@Autowired
	private ICricketerRepo icr;
	
	@Override
	public String register(Cricketer ckt) {
		
		return icr.save(ckt).getId();
//		icr.findAll().forEach(System.out::println);
//		return "";
	}

}
