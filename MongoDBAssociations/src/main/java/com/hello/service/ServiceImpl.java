package com.hello.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.hello.document.Person;
import com.hello.repository.ILicenseRepo;
import com.hello.repository.IPersonRepo;

@Service
public class ServiceImpl implements IService {

	@Autowired
	private MongoTemplate mt;
	
	@Autowired
	private IPersonRepo ipr;
	@Autowired
	private ILicenseRepo ilr;
	
	@Override
	public String register(Person p) {
		
		return ipr.save(p).getId();
		
	}
	
	@Override
	public List<Person> getPersonInfo() {
		
		
		return ipr.findAll();
	}

	@Override
	public List<Object[]> getPersonOnName(String name) {
		
		
		return ipr.getPersonOnName(name);
	}
	@Override
	public List<Person> getPersonOnNameAllProperties(String name) {
		return ipr.getPersonOnNameAllProperties(name);
		
		
	}
	@Override
	public void template() {
//		Query q = new Query();
//		q.addCriteria(Criteria.where("name").is("chinnu"));
////		q.fields().exclude("id");
//		mt.find(q, Person.class).forEach(System.out::println);
//	
//		Query q = new Query();
//		q.addCriteria(Criteria.where(""))
		
		
		
	}
}
