package com.hello.Entity;

import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "person")
@Setter
@Getter
@RequiredArgsConstructor
public class Person {
	@SequenceGenerator(name = "gen1",sequenceName = "person_sequence",initialValue = 1,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	@Id
	private Integer pid;
	@Column(length = 20)
	@NonNull
	private String pname;
	
	public Person() {
		System.out.println("person");
	}
	
//	@JoinColumn(name = "pid",referencedColumnName = "pid")
//	@OneToMany(targetEntity = MobileNumber.class, cascade = CascadeType.ALL,mappedBy= "p",fetch = FetchType.EAGER)
//	private List<MobileNumber> mno;
	
	
	
	

	

	

}
