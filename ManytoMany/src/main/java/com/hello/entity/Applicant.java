package com.hello.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "applicant")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Applicant {
	
	@SequenceGenerator(name = "gen1",sequenceName = "applicant_seq",initialValue = 1,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	@Id
	private Integer id;
	@Column(length = 20)
	@NonNull
	private String name;
	@Column(length = 20)
	@NonNull
	private String email;
	
	@ManyToMany(targetEntity = Application.class,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH ,CascadeType.REMOVE})
	@JoinTable(
			name = "applicant_job",joinColumns = @JoinColumn(name = "applicantId",referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "applicationId",referencedColumnName = "applicationId")
	)
	private List<Application> applications;
	
}
