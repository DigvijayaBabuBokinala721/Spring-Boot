package com.digvijay.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "PANCard")
@Data
@RequiredArgsConstructor
public class PANCard {

	@SequenceGenerator(name = "gen2",sequenceName = "PAN_seq",initialValue = 100,allocationSize = 10)
	@GeneratedValue(generator = "gen2",strategy = GenerationType.SEQUENCE)
	@Id
	private Integer id;
	
	@Column(length = 20)
	@NonNull
	private String panNumber;
	
	@OneToOne(targetEntity = Person.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "pid",referencedColumnName = "pid")
	private Person person;
	
}
