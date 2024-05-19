package com.excel.lms.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
import org.springframework.stereotype.Service;

import com.excel.lms.dto.EmployeePrimaryInfoDto;
import com.excel.lms.dto.EmployeeSecondaryInfoDto;
import com.excel.lms.entity.EmployeePrimaryInfo;
import com.excel.lms.entity.EmployeeSecondaryInfo;
import com.excel.lms.repository.EmployeeRepository;
import com.excel.lms.service.EmployeeService;
import com.excel.lms.util.EmployeeUtil;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public String addEmployeePrimaryInfo(EmployeePrimaryInfoDto dto) {
		EmployeePrimaryInfo employeePrimaryInfo = EmployeeUtil.employeePrimaryInfoDtoToEntity(dto);
		return employeeRepository.save(employeePrimaryInfo).getEmployeeId();
	}

	@Override
	public String addEmployeeSecondaryInfo(EmployeeSecondaryInfoDto dto) {
		Optional<EmployeePrimaryInfo> optional = employeeRepository.findByEmployeeId(dto.getEmployeeId());
		if(optional.isPresent()) {
			EmployeePrimaryInfo employee = optional.get();
			EmployeeSecondaryInfo employeeSecondaryInfo = EmployeeUtil.employeeSecondaryInfoDtoToEntity(dto);
			if(employee.getSecondary()==null) {
				employee.setSecondary(employeeSecondaryInfo);
				employeeSecondaryInfo.setEmployee(employee);
				
			} else {
				EmployeeSecondaryInfo secondary = employee.getSecondary();
				secondary.setPan(dto.getPan());
				secondary.setFatherName(dto.getFatherName());
				secondary.setAadhar(dto.getAadhar());
				secondary.setMotherName(dto.getMotherName());
				secondary.setPassportNo(dto.getPassportNo());
				secondary.setSpouse(dto.getSpouse());
				secondary.setMariatlStatus(dto.getMariatlStatus());
			}
			return employeeRepository.save(employee).getEmployeeId();
		}
		return null;
	}

}
