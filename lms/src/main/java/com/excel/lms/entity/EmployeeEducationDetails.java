package com.excel.lms.entity;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.RequestMapping;

import com.excel.lms.enums.Education;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "employee_education_info")
@RequestMapping("/educationDetails")
public class EmployeeEducationDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "education_id")
	private Integer educationId;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "education_type")
	private Education educationType;
	
	@Column(name = "year_of_passing")
	private LocalDate yearOfPassing;
	private Double percentage;
	private String instituteName;
	private String universityName;
	private String specialization;
	private String state;
	
	@ManyToOne
	@JoinColumn(name = "employee_id")
	private EmployeePrimaryInfo employee;
	
}
