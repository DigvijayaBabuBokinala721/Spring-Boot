package com.hello.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.data.builder.RepositoryItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import com.hello.model.Employee;
import com.hello.processor.Processor;
import com.hello.repository.IEmployeeRepo;

@Configuration
public class BatchConfig {

	@Autowired
	private Processor processor;
	
	@Autowired
	private IEmployeeRepo empRepo;
	
	
	@Bean
	public FlatFileItemReader<Employee> reader() {
		return new FlatFileItemReaderBuilder<Employee>()
			.name("reader")
			.resource(new ClassPathResource("emp_info.csv"))
			.linesToSkip(1)
			.delimited()
			.names("id","empName","address","email","salary")
			.targetType(Employee.class)
			.build();
	}
	
	@Bean
	public RepositoryItemWriter<Employee> writer(){
		return new RepositoryItemWriterBuilder<Employee>()
				                .repository(empRepo)
				                .methodName("save")
				                .build();
	}
	
	@Bean
	public Step createStep(JobRepository jobrepo,PlatformTransactionManager transactionManager) {
		
		return new StepBuilder("step1",jobrepo)
				.<Employee,Employee>chunk(500,transactionManager)
				.reader(reader())
				.writer(writer())
				.processor(processor)
				.build();
		
	}
	
	RunIdIncrementer rid = new RunIdIncrementer();
	
	@Bean
	public Job createJob(JobRepository jobrepo,Step step1) {
		return new JobBuilder("myjob",jobrepo)
//				.incrementer(rid) //only when spring.batch.job.enabled=true
				.start(step1)
				.build();
	}
	
	
}
