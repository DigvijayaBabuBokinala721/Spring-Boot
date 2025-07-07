package com.hello.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "student_info")
@Data
public class Student {

	@Id
	private Integer id;
	@Column(length = 20)
	private String name;
	@Column(length = 20)
	private String branch;
	
}
