package com.hello.service;

import org.springframework.stereotype.Service;

import com.hello.entity.Customer;
import com.hello.repository.CustomerRepo;

public interface ICustomerService {
	String registerCustomer(Customer customer);

	Customer updateCustomer(Customer customer);

	Customer updateCustName(String oldName,String newName);
	
	
	
}
