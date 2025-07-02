package com.hello.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hello.Entity.MobileNumber;
import com.hello.Entity.Person;
import com.hello.repository.IMobileNumberRepo;
import com.hello.repository.IPersonRepo;

@Service
public class ServiceImpl implements IService {

	@Autowired
	private IPersonRepo ipr;
	@Autowired
	private IMobileNumberRepo imr;
	
	@Override
	public String register() {
		
		Person per1 = new Person("chinnu");
		
		
		MobileNumber mn1 = new MobileNumber(123l);
		MobileNumber mn2 = new MobileNumber(321l);
		
		
		mn1.setP(per1);
		mn2.setP(per1);
		
//		per1.setMno(List.of(mn1,mn2,mn1,mn1,mn2,mn1,mn2));
		
		imr.save(mn1);
		imr.save(mn2);
		
		return "";
		
	}

	@Override
	public void findAll() {

		ipr.findAll();
		
		
	}

}
