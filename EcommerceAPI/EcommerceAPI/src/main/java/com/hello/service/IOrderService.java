package com.hello.service;

import com.hello.entity.CustomerOrder;

public interface IOrderService {
	CustomerOrder registerOrder(CustomerOrder customer);

	String delete(Long custId, Long orderId);

}
