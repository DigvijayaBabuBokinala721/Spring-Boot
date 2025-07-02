package com.hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hello.entity.Aadhaar;

public interface IAadhaarRepo extends JpaRepository<Aadhaar, Integer> {

}
