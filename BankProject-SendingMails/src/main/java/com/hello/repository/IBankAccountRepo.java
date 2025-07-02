package com.hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hello.entity.BankAccount;

public interface IBankAccountRepo extends JpaRepository<BankAccount, Long>{

}
