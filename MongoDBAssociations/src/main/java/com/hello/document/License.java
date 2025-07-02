package com.hello.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Document
//@Setter
//@Getter
@Data
public class License {
	@Id
	private String id;
	private String type;
	private Person per;
	@Override
	public String toString() {
		return "License [id=" + id + ", type= " + type + per +"]";
	}
}
