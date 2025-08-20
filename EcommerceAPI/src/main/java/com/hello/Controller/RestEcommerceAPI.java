package com.hello.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hello.entity.Customer;
import com.hello.entity.CustomerOrder;
import com.hello.service.ICustomerService;
import com.hello.service.IOrderService;

@RestController
public class RestEcommerceAPI {
	
	@Autowired
	private ICustomerService customerService;
	
	@Autowired
	private IOrderService orderService;
	
	@PostMapping("/registercustomer")
	public String registerCustomer(@RequestBody Customer customer) {
		return customerService.registerCustomer(customer);
	}
	
	@PostMapping("/orderproducts")
	public CustomerOrder orderProductsByCustomer(@RequestBody CustomerOrder customerOrder) {
		return orderService.registerOrder(customerOrder);
	}
	
	@DeleteMapping("/deleteorder")
	public String deleteOrderByCustomer(@RequestParam Long custId,@RequestParam Long orderId) {
		return orderService.delete(custId,orderId);
	}
	
	@PutMapping("/updatecustomerdetails")
	public Customer updateCustomerDetails(@RequestBody Customer customer) {
		return customerService.updateCustomer(customer);
	}
	
	@PatchMapping("/updatename")
	public Customer updateCustomerName(@RequestParam String oldName,@RequestParam String newName) {
		return customerService.updateCustName(oldName,newName);
	}
}
