package com.digvijay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digvijay.entity.PANCard;
import com.digvijay.repository.IPANCardRepo;

@Service
public class IPANServiceImpl implements IPANService{
	
	@Autowired
	private IPANCardRepo pancardRepo;
	
	@Override
	public String register(PANCard pancard) {

		return pancardRepo.save(pancard).getPanNumber() + " registered successfully ";
		
	}
}
