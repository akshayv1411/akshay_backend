package com.excel.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.excel.lms.dto.EducationListDto;
import com.excel.lms.dto.EmployeeAddressListDto;
import com.excel.lms.dto.EmployeeBankInfoDto;
import com.excel.lms.dto.EmployeeContactInfoListDto;
import com.excel.lms.dto.EmployeeExperienceInfoDto;
import com.excel.lms.dto.EmployeeExperienceListDto;
import com.excel.lms.dto.EmployeePrimaryInfoDto;
import com.excel.lms.dto.EmployeeSecondaryInfoDto;
import com.excel.lms.dto.EmployeeTechnicalSkillsListDto;
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
	
	@PostMapping(path = "/eduinfo/add")
	public ResponseEntity<String> addEmployeeEducationInfo(@RequestBody EducationListDto educationListDto){
		String employeeId = employeeService.addEmployeeEducationInfo(educationListDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeId);
	}
	
	@PostMapping(path = "/exinfo/add")
	public ResponseEntity<String> addEmployeeExperienceInfo(@RequestBody EmployeeExperienceListDto experienceListDto){
		String employeeId = employeeService.addEmployeeExperienceInfo(experienceListDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeId);
	}
	
	@PostMapping(path = "/ainfo/add")
	public ResponseEntity<String> addAddressInfo(@RequestBody EmployeeAddressListDto addressListDto){
		String employeeId = employeeService.addAddressInfo(addressListDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeId);
	}
	
	@PostMapping(path = "/cinfo/add")
	public ResponseEntity<String> addContactInfo(@RequestBody EmployeeContactInfoListDto contactInfoListDto) {
		String employeeId = employeeService.addContactInfo(contactInfoListDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeId);
	}
	
	@PostMapping(path = "/skills/add")
	public ResponseEntity<String> addSkillsInfo(@RequestBody EmployeeTechnicalSkillsListDto skillsDto){
		String employeeId = employeeService.addSkillsInfo(skillsDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeId);
	}
	
}
