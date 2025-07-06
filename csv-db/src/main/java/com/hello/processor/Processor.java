package com.hello.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.hello.model.Employee;


@Component
public class Processor implements ItemProcessor<Employee, Employee> {
	@Override
	public Employee process(Employee item) throws Exception {
		
//		if(item.getSalary() > 50_000.) {
//			return item;
//		}
		
		return item;
	}
}
