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
	    Customer customer = customerRepo.findById(custId)
	            .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + custId));

	    CustomerOrder order = ordersRepo.findById(orderId)
	            .orElseThrow(() -> new RuntimeException("Order not found with ID: " + orderId));

	    // Check if order belongs to the same customer
	    if (!order.getCustomer().getCustId().equals(custId)) {
	        throw new RuntimeException("Order " + orderId + " does not belong to customer " + custId);
	    }

	    ordersRepo.delete(order);
	    return "Order " + orderId + " deleted successfully for customer " + customer.getCustName();
	}

}
