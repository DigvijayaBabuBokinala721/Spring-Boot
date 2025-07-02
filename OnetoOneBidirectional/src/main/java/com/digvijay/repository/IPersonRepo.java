package com.digvijay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digvijay.entity.Person;

public interface IPersonRepo extends JpaRepository<Person, Integer> {

}
