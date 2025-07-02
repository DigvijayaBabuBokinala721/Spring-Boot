package com.hello.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.hello.document.Person;

public interface IPersonRepo extends MongoRepository<Person, String> {
	
	
	@Query(fields= "{id:0,name:1, license:1}",value = "{name:?0}")
	public List<Object[]> getPersonOnName(String name);
	
	@Query(value = "{name:?0}")
	public List<Person> getPersonOnNameAllProperties(String name);
}
