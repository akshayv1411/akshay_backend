package com.excel.lms.dto;

import jakarta.persistence.Column;
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
public class EmployeeBankInfoDto {
	private String employeeId;
	private Long accountNo;
	private String bankName;
	private String accountType;
	private String ifscCode;
	private String branch;
	private String state;
}
