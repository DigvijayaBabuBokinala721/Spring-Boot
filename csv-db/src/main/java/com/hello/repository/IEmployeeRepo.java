package com.hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hello.model.Employee;

public interface IEmployeeRepo extends JpaRepository<Employee, Integer> {

}
