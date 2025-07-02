package com.hello.service;

import java.util.List;

import com.hello.document.Person;

public interface IService {
	public String register(Person p);
	public List<Person> getPersonInfo();
	public List<Object[]> getPersonOnName(String name);
	public List<Person> getPersonOnNameAllProperties(String name);
	public void template();
}
