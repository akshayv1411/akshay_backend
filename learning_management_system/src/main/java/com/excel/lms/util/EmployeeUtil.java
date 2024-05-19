package com.excel.lms.util;

import com.excel.lms.dto.EmployeePrimaryInfoDto;
import com.excel.lms.dto.EmployeeSecondaryInfoDto;
import com.excel.lms.entity.EmployeePrimaryInfo;
import com.excel.lms.entity.EmployeeSecondaryInfo;

public class EmployeeUtil {

	public static EmployeePrimaryInfo employeePrimaryInfoDtoToEntity(EmployeePrimaryInfoDto dto) {
		return EmployeePrimaryInfo.builder()
			.employeeId(dto.getEmployeeId())
			.employeeName(dto.getEmployeeName())
			.dateOfJoining(dto.getDateOfJoining())
			.dateOfBirth(dto.getDateOfBirth())
			.email(dto.getEmail())
			.bloodGroup(dto.getBloodGroup())
			.designation(dto.getDesignation())
			.gender(dto.getGender())
			.nationality(dto.getNationality())
			.employeeStatus(dto.getEmployeeStatus())
			.build();
	}
	
	public static EmployeePrimaryInfoDto employeePrimaryInfoEntitytoDto(EmployeePrimaryInfo employee) {
		return EmployeePrimaryInfoDto.builder()
			.id(employee.getId())
			.employeeId(employee.getEmployeeId())
			.employeeName(employee.getEmployeeName())
			.dateOfJoining(employee.getDateOfJoining())
			.dateOfBirth(employee.getDateOfBirth())
			.email(employee.getEmail())
			.bloodGroup(employee.getBloodGroup())
			.designation(employee.getDesignation())
			.gender(employee.getGender())
			.nationality(employee.getNationality())
			.employeeStatus(employee.getEmployeeStatus())
			.build();
	}
	
	public static EmployeeSecondaryInfo employeeSecondaryInfoDtoToEntity(EmployeeSecondaryInfoDto dto) {
		return EmployeeSecondaryInfo.builder()
				.pan(dto.getPan())
				.aadhar(dto.getAadhar())
				.fatherName(dto.getFatherName())
				.motherName(dto.getMotherName())
				.spouse(dto.getSpouse())
				.passportNo(dto.getPassportNo())
				.mariatlStatus(dto.getMariatlStatus())
				.build();
		}
	
//	public static EmployeeSecondaryInfoDto employeeSecondaryInfoEntityToDto(EmployeeSecondaryInfo employee) {
//		return EmployeeSecondaryInfoDto.builder()
//				.employeeSecondaryId(employee.getEmployeeSecondaryId())
//				.pan(employee.getPan())
//				.aadhar(employee.getAadhar())
//				.fatherName(employee.getFatherName())
//				.motherName(employee.getMotherName())
//				.spouse(employee.getSpouse())
//				.passportNo(employee.getPassportNo())
//				.mariatlStatus(employee.getMariatlStatus())
//				.build();
//	}
}
