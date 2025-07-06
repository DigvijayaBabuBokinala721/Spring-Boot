package com.hello.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "emp_info")
public class Employee {
	@Id
	private Integer id;
	@Column(length = 40)
	private String empName;
	@Column(length = 40)
	private String address;
	@Column(length = 40)
	private String email;
	private Double salary;
	
}
