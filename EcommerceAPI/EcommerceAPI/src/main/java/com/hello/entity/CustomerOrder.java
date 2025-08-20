package com.hello.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Entity
@Data
public class CustomerOrder {
	
	@Id
	@SequenceGenerator(name = "gen2",sequenceName = "order_seq",initialValue = 1010,allocationSize = 10)
	@GeneratedValue(generator = "gen2",strategy = GenerationType.SEQUENCE)
	private Long orderId;
	private String productName;
	private Double price;
	@ManyToOne(targetEntity = Customer.class)
	@JoinColumn(name = "custid",referencedColumnName = "custId")
	@JsonBackReference
	private Customer customer;
	
	
}
