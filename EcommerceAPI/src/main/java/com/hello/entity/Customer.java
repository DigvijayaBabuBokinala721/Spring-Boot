package com.hello.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Entity
@Data
public class Customer {
	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "customer_seq",initialValue = 1010,allocationSize = 10)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Long custId;
	@Column(length = 30, unique = true)
	private String custName;
	
	private Long mobileNo;
	
	@OneToMany(targetEntity = CustomerOrder.class,cascade = CascadeType.ALL,mappedBy = "customer")
	@JsonManagedReference
	private List<CustomerOrder> orders;
	
}
