package com.hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hello.entity.CustomerOrder;

public interface OrdersRepo extends JpaRepository<CustomerOrder,Long> {

}
