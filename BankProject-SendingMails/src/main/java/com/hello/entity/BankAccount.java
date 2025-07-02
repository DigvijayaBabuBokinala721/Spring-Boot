package com.hello.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Entity
@Table(name = "bankaccount")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class BankAccount {

	@SequenceGenerator(name = "gen3",sequenceName = "sequ3",initialValue = 1,allocationSize = 1)
	@GeneratedValue(generator = "gen3",strategy = GenerationType.SEQUENCE)
	@Id
	private long accNo;
	
	@NonNull
	private double balance;
	
	@Column(length = 20)
	@NonNull
	private String type;
	
	@ManyToOne(targetEntity = Person.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "pid",referencedColumnName = "pid")
	private Person person;
}
