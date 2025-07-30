package com.hello.entity;

import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
//@Data
@Setter
@Getter
@NoArgsConstructor
//@Table(name = "users1")
public class Users {
	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "users_seq",initialValue = 1,allocationSize = 2)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String username;
	private String password;
	
//	@OneToMany(targetEntity = Roles.class,cascade = CascadeType.ALL,mappedBy = "user")
//	@JsonManagedReference
//	private List<String> roles;
	
//	@ElementCollection
//	@CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "username"))
//	@Column(name = "role_name")
//	private List<String> roles;
	
	
	@ManyToMany(targetEntity = Roles.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name = "user_roles",joinColumns = @JoinColumn(name = "userid")
				,inverseJoinColumns = @JoinColumn(name = "role")
			)
	private Set<Roles> roles;
	
	
	
}
