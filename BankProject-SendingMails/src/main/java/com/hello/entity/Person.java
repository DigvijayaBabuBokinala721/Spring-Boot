package com.hello.entity;

import java.util.List;

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
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "person_bk")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Person {
	
	@SequenceGenerator(name = "gen1",sequenceName = "sequ1",initialValue = 1,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	@Id
	private Integer pid;

	@Column(length = 20)
	@NonNull
	private String name;
	
	@Column(length = 40)
	@NonNull
	private String email;

	@OneToOne(targetEntity = Aadhaar.class,cascade = CascadeType.ALL)
	@NonNull
	private Aadhaar aadhaar;
	
	
	
	@OneToMany(targetEntity = BankAccount.class,cascade = CascadeType.ALL)
	@NonNull
	private List<BankAccount> bankAccount;
	
}
