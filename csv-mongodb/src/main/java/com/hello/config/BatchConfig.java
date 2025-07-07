package com.hello.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.MongoItemWriter;
import org.springframework.batch.item.data.builder.MongoItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.transaction.PlatformTransactionManager;

import com.hello.document.Employee;

@Configuration
public class BatchConfig {
	
	 	@Bean
	    public FlatFileItemReader<Employee> reader() {
	        return new FlatFileItemReaderBuilder<Employee>()
	            .name("personItemReader")
	            .resource(new ClassPathResource("emp_info.csv"))
	            .linesToSkip(1)
	            .delimited()
	            .names("id", "name", "address","email","salary")
	            .targetType(Employee.class)
	            .build();
	    }
	 	
	 	
	 	@Bean
	 	public MongoItemWriter<Employee> writer(MongoTemplate mongoTemplate) {
	 	    return new MongoItemWriterBuilder<Employee>()
	 	        .template(mongoTemplate)
	 	        .collection("employees")
	 	        .build();
	 	}
	
	 	@Bean
	 	public Step step(JobRepository jobRepository,
	 	                 PlatformTransactionManager transactionManager,
	 	                 FlatFileItemReader<Employee> reader,
	 	                 MongoItemWriter<Employee> writer) {

	 	    return new StepBuilder("csv-to-mongo-step", jobRepository)
	 	        .<Employee, Employee>chunk(100, transactionManager)
	 	        .reader(reader)
	 	        .writer(writer)
	 	        .build();
	 	}
	 	
	 	@Bean
	 	public Job job(JobRepository jobRepository, Step step) {
	 	    return new JobBuilder("csvToMongoJob", jobRepository)
	 	        .incrementer(new RunIdIncrementer())  // So we can run the job multiple times when enable is true
	 	        .start(step)
	 	        .build();
	 	}
	 	
	 	
	 	
}
