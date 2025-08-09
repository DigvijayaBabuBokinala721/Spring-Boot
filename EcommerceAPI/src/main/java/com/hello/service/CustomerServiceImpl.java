package com.hello.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hello.entity.Customer;
import com.hello.repository.CustomerRepo;

@Service
public class CustomerServiceImpl implements ICustomerService{
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Override
	public String registerCustomer(Customer customer) {
		if(customerRepo.findByCustName(customer.getCustName()).isPresent()) {
			throw new RuntimeException("username already there");
		}
		
		return customerRepo.save(customer).getCustName() + " saved";
	}
	
	@Override
	public Customer updateCustomer(Customer customer) {
		Optional<Customer> opt = customerRepo.findById(customer.getCustId());
		
		if(opt.isPresent()) {
			Customer existingcust = opt.get();
			existingcust.setCustName(customer.getCustName());
			existingcust.setMobileNo(customer.getMobileNo());
			return customerRepo.save(existingcust);
		}
		else {
			throw new RuntimeException("no user present");
		}
	}
	
	@Override
	public Customer updateCustName(String oldName,String newName) {
		Optional<Customer> opt = customerRepo.findByCustName(oldName);
		if(opt.isPresent()) {
			Customer cust = opt.get();
			cust.setCustName(newName);
			return customerRepo.save(cust);
		}
		else {
			throw new RuntimeException("no user present");
		}
	}
}
