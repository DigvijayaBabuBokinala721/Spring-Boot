package com.hello.processor;

import org.springframework.batch.item.ItemProcessor;

import com.hello.model.Student;

public class Processor implements ItemProcessor<Student, Student>{
	
	@Override
	public Student process(Student item) throws Exception {
		return item;
	}
	
}
