package com.hello.service;

import com.hello.entity.Person;

import jakarta.mail.MessagingException;

public interface IpersonService {
	public String register(Person p) throws MessagingException;
	public double withdraw(long accNo,double amt) throws MessagingException;
} 
