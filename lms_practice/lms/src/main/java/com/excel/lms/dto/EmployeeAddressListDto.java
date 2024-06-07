package com.excel.lms.dto;

import java.util.List;

import com.excel.lms.entity.EmployeeAddress;

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
public class EmployeeAddressListDto {
	private String employeeId;
	private List<EmployeeAddressDto> allAdrress;
}
