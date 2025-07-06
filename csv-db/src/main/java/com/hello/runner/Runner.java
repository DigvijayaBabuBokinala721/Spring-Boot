package com.hello.runner;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

	@Autowired
	private Job job;
	
	@Autowired
	private JobLauncher launcher;
	@Override
	public void run(String... args) throws Exception {

		JobParameters jobparams = new JobParametersBuilder().addLong("long", System.currentTimeMillis()).toJobParameters();
		
		JobExecution exe =  launcher.run(job, jobparams);
		
		System.out.println(exe.getStatus());
		
	}

}
