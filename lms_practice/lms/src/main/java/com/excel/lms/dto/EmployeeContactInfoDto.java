package com.excel.lms.dto;

import com.excel.lms.enums.Contact;

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
public class EmployeeContactInfoDto {
	private String employeeId;
	private Contact contactType;
	private Long contactNumber;
	
}
