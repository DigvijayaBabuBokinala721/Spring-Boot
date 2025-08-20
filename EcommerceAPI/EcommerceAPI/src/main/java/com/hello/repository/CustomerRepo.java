package com.hello.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hello.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer,Long>{

	Optional<Customer> findByCustName(String custName);

}
