package com.hello.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "mobilenumber")
public class MobileNumber {
	
	@SequenceGenerator(name = "gen1",sequenceName = "mobilenumber_seq",initialValue = 1,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	@Id
	private Integer regno;
	@NonNull
	private Long mno;
	
	
	@ManyToOne(targetEntity = Person.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "pid",referencedColumnName = "pid")
	private Person p;
	
	
	
	
}
