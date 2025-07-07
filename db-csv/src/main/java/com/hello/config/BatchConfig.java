package com.hello.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;

import com.hello.model.Student;

import jakarta.persistence.EntityManagerFactory;

@Configuration
public class BatchConfig {
	  @Bean
	  public JpaPagingItemReader<Student> reader(EntityManagerFactory emf) {
	        return new JpaPagingItemReaderBuilder<Student>()
	                .name("jpaReader")
	                .entityManagerFactory(emf)
	                .queryString("SELECT s FROM Student s")
	                .pageSize(10)
	                .build();
	  }
	  
	    @Bean
	    public FlatFileItemWriter<Student> writer() {
	        return new FlatFileItemWriterBuilder<Student>()
	                .name("csvWriter")
	                .resource(new FileSystemResource("student.csv"))
	                .delimited()
	                .delimiter(",")
	                .names("id", "name", "branch")
	                .headerCallback(writer -> writer.write("ID,Name,branch"))
	                .build();
	    }
	    
	    @Bean
	    public Step step(JobRepository jobRepository,
                PlatformTransactionManager transactionManager,
                JpaPagingItemReader<Student> reader) {
	    	
	    	return new StepBuilder("mystep",jobRepository)
	    			.<Student,Student>chunk(2, transactionManager)
	    			.reader(reader)
	    			.writer(writer()).build();
	    	
	    }
	    
	    @Bean
	    public Job job(JobRepository jobRepository, Step step) {
	        return new JobBuilder("exportJob", jobRepository)
	                .start(step)
	                .incrementer(new RunIdIncrementer())
	                .build();
	    }
	  
}
