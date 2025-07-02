package com.hello.document;

import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Document
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Cricketer {
	@Id
	private String id;
	@NonNull
	private Integer sno;
	@NonNull
	private String name;
	@NonNull
	private String role;
	@NonNull
	private Map<String, String> nationalityIpl;
	@NonNull
	private List<String> li;
	
}
