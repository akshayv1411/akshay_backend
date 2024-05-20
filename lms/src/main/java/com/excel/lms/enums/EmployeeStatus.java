package com.excel.lms.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum EmployeeStatus {

	ACTIVE("ACTIVE"),
	TERMINATE("TERMINATE"),
	ABSCOND("ABSCOND");
	
	private final String employeeStatus;
	
}
