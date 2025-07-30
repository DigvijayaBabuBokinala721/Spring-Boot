package com.hello.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
//@Table(name = "roles1")
@Data
public class Roles {
	
	
	@Id
	@SequenceGenerator(name = "gen2",sequenceName = "role_seq",initialValue = 1,allocationSize = 1)
	@GeneratedValue(generator = "gen2",strategy = GenerationType.SEQUENCE)
	private Integer id;
	@Column(name = "role_name") 
	private String role;
	
//	@ManyToOne(targetEntity = Users.class,cascade = CascadeType.ALL)
//	@JoinColumn(name = "userid",referencedColumnName = "id")
//	@JsonBackReference
//	private Users user;
	
	@ManyToMany(targetEntity = Users.class,cascade = CascadeType.ALL,mappedBy = "roles")
	private Set<Users> user;
	
	
}
