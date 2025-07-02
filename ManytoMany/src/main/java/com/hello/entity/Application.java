package com.hello.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "application")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Application {

	@SequenceGenerator(name = "gen2",sequenceName = "application_seq",initialValue = 1,allocationSize = 1)
	@GeneratedValue(generator = "gen2",strategy = GenerationType.SEQUENCE)
	@Id
	private Integer applicationId;
	@Column(length = 20)
	@NonNull
	private String title;
	
	
	
	
	
}
