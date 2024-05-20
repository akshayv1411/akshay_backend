package com.excel.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.excel.lms.dto.EmployeeBankInfoDto;
import com.excel.lms.dto.EmployeePrimaryInfoDto;
import com.excel.lms.dto.EmployeeSecondaryInfoDto;
import com.excel.lms.service.EmployeeService;


@RestController
@RequestMapping(path = "/api", method = {RequestMethod.POST, RequestMethod.PUT})
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping(path = "/pinfo/add")
	public ResponseEntity<String> addEmployeePrimaryInfo(@RequestBody EmployeePrimaryInfoDto employeePrimaryInfoDto){
		String employeeId = employeeService.addEmployeePrimaryInfo(employeePrimaryInfoDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeId);
	}
	
	@PostMapping(path = "/sinfo/add")
	public ResponseEntity<String> addEmployeeSecondaryInfo(@RequestBody EmployeeSecondaryInfoDto employeeSecondaryInfoDto){
		String employeeId = employeeService.addEmployeeSecondaryInfo(employeeSecondaryInfoDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeId);
	}
	
	@PostMapping(path = "/binfo/add")
	public ResponseEntity<String> addEmployeeBankInfo(@RequestBody EmployeeBankInfoDto employeeBankInfoDto){
		String employeeId = employeeService.addEmployeeBankInfo(employeeBankInfoDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeId);
	}
}
