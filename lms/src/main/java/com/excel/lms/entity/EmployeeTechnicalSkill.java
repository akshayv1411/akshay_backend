package com.excel.lms.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee_technical_info")
public class EmployeeTechnicalSkill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "technical_id")
	private Integer technicalkId;
	
	@Column(name = "skill_type")
	private String skillType;
	
	@Column(name = "skill_rating")
	private String skillRating;
	
	@Column(name = "years_of_experience")
	private Double yearOfExperience;
	
	@ManyToMany
	@JoinColumn(name = "employees_id")
	private List<EmployeePrimaryInfo> employees;
}
