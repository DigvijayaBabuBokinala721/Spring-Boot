package com.hello.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.hello.entity.Person;

public interface IPersonRepo extends JpaRepository<Person, Integer> {

}
