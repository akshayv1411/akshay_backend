package com.excel.lms.entity;

import com.excel.lms.enums.MaritalStatus;

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
import jakarta.persistence.OneToOne;
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
@Table(name = "employee_secondary_info")
public class EmployeeSecondaryInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_secondary_id")
	private Integer employeeSecondaryNumber;
	private String pan;
	private String aadhar;
	private String fatherName;
	private String motherName;
	private String spouse;

	@Column(name = "passport_no")
	private String passportNo;

	@Enumerated(EnumType.STRING)
	private MaritalStatus mariatlStatus;
	
	@JoinColumn(name = "employeeId")
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private EmployeePrimaryInfo employee;
	
}
