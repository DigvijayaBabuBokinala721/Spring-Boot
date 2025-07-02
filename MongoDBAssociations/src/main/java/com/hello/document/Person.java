package com.hello.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Document(collection = "person_p")
//@Setter
//@Getter
@Data
public class Person {
	@Id
	private String id;
	private String name;
	private License license;
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name +", " + license + "]";
	}
	
	
}
