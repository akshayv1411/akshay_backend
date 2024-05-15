package com.excel.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.excel.demo.dto.EmployeeDto;
import com.excel.demo.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController

public class BaseController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/home")
	public ResponseEntity<String> homeGetReq() {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("hello akshay");
	}
	
	@PostMapping("/add")
	public ResponseEntity<EmployeeDto> addEmployee (@RequestBody EmployeeDto employee) {
		EmployeeDto dto = employeeService.addEmployee(employee);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
	}
	

	
	
}
