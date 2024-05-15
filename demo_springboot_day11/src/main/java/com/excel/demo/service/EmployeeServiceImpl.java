package com.excel.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excel.demo.dto.EmployeeDto;
import com.excel.demo.entity.Employee;
import com.excel.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public EmployeeDto addEmployee(EmployeeDto dto) {
		Employee employee = Employee.builder().firstName(dto.getFirstName()).
				lastName(dto.getLastName())
				.mobileNo(dto.getMobileNo())
				.aadharNo(dto.getAadharNo())
				.panNo(dto.getPanNo())
				.employeeNo(dto.getEmployeeNo()).build();
		
		Employee save = employeeRepository.save(employee);
		
		return EmployeeDto.builder().id(save.getId())
				.firstName(save.getFirstName())
				.lastName(save.getLastName())
				.mobileNo(save.getMobileNo())
				.aadharNo(save.getAadharNo())
				.panNo(save.getPanNo())
				.employeeNo(save.getEmployeeNo()).build();
	}
}


