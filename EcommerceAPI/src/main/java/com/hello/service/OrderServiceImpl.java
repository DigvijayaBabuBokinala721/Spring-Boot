package com.hello.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.hello.entity.Customer;
import com.hello.entity.CustomerOrder;
import com.hello.repository.CustomerRepo;
import com.hello.repository.OrdersRepo;

@Service
public class OrderServiceImpl implements IOrderService{
	
	@Autowired
	private OrdersRepo ordersRepo;
	@Autowired
	private CustomerRepo customerRepo;
	
	@Override
	public CustomerOrder registerOrder(CustomerOrder customerOrder) {
		Optional<Customer> opt = customerRepo.findByCustName(customerOrder.getCustomer().getCustName());
		
		if(opt.isPresent()) {
			customerOrder.setCustomer(opt.get());
		}else {
			throw new NullPointerException();
		}
		
		return ordersRepo.save(customerOrder);
		
	}
	@Override
	public String delete(Long custId, Long orderId) {
	    Optional<Customer> optCustomer = customerRepo.findById(custId);
	    if (optCustomer.isPresent()) {
	        Customer customer = optCustomer.get();
	        boolean orderExists = customer.getOrders().stream()
	                .anyMatch(order -> order.getOrderId().equals(orderId));

	        if (orderExists) {
	            ordersRepo.deleteById(orderId);
	            return "Order " + orderId + " deleted successfully for customer " + customer.getCustName();
	        } else {
	            return "Order " + orderId + " not found for this customer.";
	        }
	    } else {
	        throw new RuntimeException("Customer not found with ID: " + custId);
	    }
	}
}
