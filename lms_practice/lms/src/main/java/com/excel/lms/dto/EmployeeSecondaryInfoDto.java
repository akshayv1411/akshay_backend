package com.excel.lms.dto;

import com.excel.lms.enums.MaritalStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeSecondaryInfoDto {
	private Integer employeeSecondaryNumber;
	private String employeeId;
	private String pan;
	private String aadhar;
	private String fatherName;
	private String motherName;
	private String spouse;
	private String passportNo;
	private MaritalStatus mariatlStatus;
}