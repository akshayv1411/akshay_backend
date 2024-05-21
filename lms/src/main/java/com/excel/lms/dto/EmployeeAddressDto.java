package com.excel.lms.dto;

import com.excel.lms.enums.Address;

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
public class EmployeeAddressDto {
	
	private Address addressType;
	private String doorNo;
	private String street;
	private String locality;
	private String city;
	private String state;
	private String pinCode;
	private String landMark;
}
