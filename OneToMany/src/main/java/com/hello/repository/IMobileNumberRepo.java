package com.hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hello.Entity.MobileNumber;

public interface IMobileNumberRepo extends JpaRepository<MobileNumber, Integer> {

}
