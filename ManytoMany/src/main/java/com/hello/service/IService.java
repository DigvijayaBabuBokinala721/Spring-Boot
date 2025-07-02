package com.hello.service;

import com.hello.entity.Applicant;

public interface IService {
	public String register(Applicant applicant,String... applications);
}
