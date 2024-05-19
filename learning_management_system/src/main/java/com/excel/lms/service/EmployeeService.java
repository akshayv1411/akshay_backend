package com.excel.lms.service;


import com.excel.lms.dto.EmployeePrimaryInfoDto;
import com.excel.lms.dto.EmployeeSecondaryInfoDto;

public interface EmployeeService {

	String addEmployeePrimaryInfo(EmployeePrimaryInfoDto dto);

	String addEmployeeSecondaryInfo(EmployeeSecondaryInfoDto dto);

}