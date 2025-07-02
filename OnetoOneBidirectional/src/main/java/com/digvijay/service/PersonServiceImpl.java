package com.digvijay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digvijay.entity.Person;
import com.digvijay.repository.IPersonRepo;

@Service
public class PersonServiceImpl implements IpersonService{

	@Autowired
	private IPersonRepo personRepo;
	
	@Override
	public String regiser(Person p) {

		return personRepo.save(p).getName() + " Registered Successfully";
		
	}
}
