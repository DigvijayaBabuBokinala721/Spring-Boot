package com.hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hello.Entity.Person;

public interface IPersonRepo extends JpaRepository<Person, Integer> {

}
