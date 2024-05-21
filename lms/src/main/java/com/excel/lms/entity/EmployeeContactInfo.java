package com.excel.lms.entity;

import com.excel.lms.enums.Contact;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "employee_contact_info")
public class EmployeeContactInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "contact_Id")
	private Integer contactId;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "contact_type")
	private Contact contactType;
	
	@Column(name = "contact_number")
	private Long contactNumber; 
	
	@ManyToOne
	@JoinColumn(name = "emplyee_id")
	private EmployeePrimaryInfo employee;
}