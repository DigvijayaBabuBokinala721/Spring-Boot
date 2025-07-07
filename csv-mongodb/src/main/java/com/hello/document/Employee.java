package com.hello.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "employee_info")
public class Employee {
	@Id
	private Integer id;
	private String empName;
	private String address;
	private String email;
	private Double salary;
	
}
