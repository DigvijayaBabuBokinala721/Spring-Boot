package com.digvijay.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "PersonOnetoOne")
@Data
@RequiredArgsConstructor
public class Person {

	@SequenceGenerator(name = "gen1",sequenceName = "persononetoone_seq",initialValue = 100,allocationSize = 10)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	@Id
	private Integer pid;
	
	@Column(length = 20)
	@NonNull
	private String name;
	
	@OneToOne(targetEntity = PANCard.class,cascade = CascadeType.ALL,mappedBy = "person")
	@NonNull
	private PANCard pancard;
	
}
