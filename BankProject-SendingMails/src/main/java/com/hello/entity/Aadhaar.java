package com.hello.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Aadhaar {
	@SequenceGenerator(name = "gen1",sequenceName = "sequ2",initialValue = 1,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	@Id
	private Integer id;
	@NonNull
	private Long aadhaarNo;
	
	@OneToOne(targetEntity = Person.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "pid",referencedColumnName = "pid")
	private Person person;
}
