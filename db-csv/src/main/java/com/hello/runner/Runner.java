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
public class Runner implements CommandLineRunner{
	@Autowired
	private JobLauncher launcher;
	@Autowired
	private Job job;
	
	
	@Override
	public void run(String... args) throws Exception {

		JobParameters parameters = new JobParametersBuilder()
				.addLong("time", System.currentTimeMillis()).toJobParameters();
		
//		JobExecution exe = launcher.run(job, parameters);
//		System.out.println(exe.getStatus());
	}
}
