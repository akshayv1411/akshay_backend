package com.excel.lms.entity;


import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee_experience_info")
public class EmployeeExperienceInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "experience_id")
	private Integer experienceId;
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "years_of_experience")
	private Double yearOfExperience;
	
	@Column(name = "date_of_joining")
	private LocalDate dateOfJoining;
	
	@Column(name = "date_of_relieving")
	private LocalDate dateOfRelieving;
	private String designation;
	private String location;
	
	
	@ManyToOne
	@JoinColumn(name = "employee_primary_info")
	private EmployeePrimaryInfo employee;
}
