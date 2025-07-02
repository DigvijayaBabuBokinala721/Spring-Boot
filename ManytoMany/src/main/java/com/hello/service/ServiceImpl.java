package com.hello.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hello.entity.Applicant;
import com.hello.entity.Application;
import com.hello.repository.IApplicantRepo;
import com.hello.repository.IApplicationRepo;


@Service
public class ServiceImpl implements IService {
	
	@Autowired
	private IApplicantRepo ipr;
	@Autowired
	private IApplicationRepo iar;
	
	@Override
	public String register(Applicant applicant, String... applcations) {
		
		List<Application> li = new ArrayList<Application>();
		for(String application:applcations) {
			Optional<Application> opt = iar.findByTitle(application);
			if(opt.isPresent()) {
				Application app = opt.get();
				li.add(app);
			}
			else {
				Application a = new Application(application);
				li.add(iar.save(a));
			}
			
		}
		applicant.setApplications(li);
		
		return ipr.save(applicant).getName();
		
	}
}
