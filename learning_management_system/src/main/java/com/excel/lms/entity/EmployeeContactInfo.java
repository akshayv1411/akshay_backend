package com.excel.lms.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Builder
@AllArgsConstructor
@Table(name = "employee_contact_info")


public class EmployeeContactInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private String contactType;
	private Integer contactNo;

}
