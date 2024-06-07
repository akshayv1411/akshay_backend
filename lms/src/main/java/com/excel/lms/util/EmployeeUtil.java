package com.excel.lms.util;

import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

import com.excel.lms.dto.EducationListDto;
import com.excel.lms.dto.EmployeeAddressDto;
import com.excel.lms.dto.EmployeeBankInfoDto;
import com.excel.lms.dto.EmployeeContactInfoDto;
import com.excel.lms.dto.EmployeeEducationDetailsDto;
import com.excel.lms.dto.EmployeeExperienceInfoDto;
import com.excel.lms.dto.EmployeePrimaryInfoDto;
import com.excel.lms.dto.EmployeeSecondaryInfoDto;
import com.excel.lms.dto.EmployeeTechnicalSkillDto;
import com.excel.lms.entity.EmployeeAddress;
import com.excel.lms.entity.EmployeeBankInfo;
import com.excel.lms.entity.EmployeeContactInfo;
import com.excel.lms.entity.EmployeeEducationDetails;
import com.excel.lms.entity.EmployeeExperienceInfo;
import com.excel.lms.entity.EmployeePrimaryInfo;
import com.excel.lms.entity.EmployeeSecondaryInfo;
import com.excel.lms.entity.EmployeeTechnicalSkill;

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
	
//	public static EmployeePrimaryInfoDto employeePrimaryInfoEntitytoDto(EmployeePrimaryInfo employee) {
//		return EmployeePrimaryInfoDto.builder()
//			.id(employee.getId())
//			.employeeId(employee.getEmployeeId())
//			.employeeName(employee.getEmployeeName())
//			.dateOfJoining(employee.getDateOfJoining())
//			.dateOfBirth(employee.getDateOfBirth())
//			.email(employee.getEmail())
//			.bloodGroup(employee.getBloodGroup())
//			.designation(employee.getDesignation())
//			.gender(employee.getGender())
//			.nationality(employee.getNationality())
//			.employeeStatus(employee.getEmployeeStatus())
//			.build();
//	}
	
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
	
	public static EmployeeBankInfo employeeBankInfoDtoToEntity(EmployeeBankInfoDto dto) {
		return EmployeeBankInfo.builder()
				.accountNo(dto.getAccountNo())
				.bankName(dto.getBankName())
				.accountType(dto.getAccountType())
				.ifscCode(dto.getIfscCode())
				.branch(dto.getBranch())
				.state(dto.getState())
				.build();
	}
	
	public static List<EmployeeEducationDetails> employeeEducationDetailsDtoToEntity(List<EmployeeEducationDetailsDto> dto) {
	    return dto.stream().map(edu -> EmployeeEducationDetails.builder()
	            .educationType(edu.getEducationType())
	            .yearOfPassing(edu.getYearOfPassing())
	            .percentage(edu.getPercentage())
	            .instituteName(edu.getInstituteName())
	            .universityName(edu.getUniversityName())
	            .specialization(edu.getSpecialization())
	            .state(edu.getState())
	            .build())
	            .collect(Collectors.toList());
	}
	
	public static List<EmployeeExperienceInfo> employeeExperienceInfoDtoToEntity(List<EmployeeExperienceInfoDto> dto){
		return dto.stream().map(ex -> EmployeeExperienceInfo.builder()
				.companyName(ex.getCompanyName())
				.yearOfExperience(ex.getYearOfExperience())
				.dateOfJoining(ex.getDateOfJoining())
				.dateOfRelieving(ex.getDateOfRelieving())
				.designation(ex.getDesignation())
				.location(ex.getLocation())
				.build())
				.collect(Collectors.toList());
	}
	
	public static List<EmployeeAddress> employeeAddreessInfoDtoToEntity(List<EmployeeAddressDto> dto){
		return dto.stream().map(address -> EmployeeAddress.builder()
				.addressType(address.getAddressType())
				.doorNo(address.getDoorNo())
				.street(address.getStreet())
				.locality(address.getLocality())
				.city(address.getCity())
				.state(address.getState())
				.pinCode(address.getPinCode())
				.landMark(address.getLandMark())
				.build())
				.collect(Collectors.toList());
	}
	
	public static List<EmployeeContactInfo> employeeContactInfoDtoToEntity(List<EmployeeContactInfoDto> dto){
		return dto.stream().map(con -> EmployeeContactInfo.builder()
				.contactType(con.getContactType())
				.contactNumber(con.getContactNumber())
				.build())
				.collect(Collectors.toList());
	}
	
	public static EmployeeTechnicalSkill employeeTechnicalSkillsInfoDtoToEntity(EmployeeTechnicalSkillDto dto){
		return EmployeeTechnicalSkill.builder()
				.skillType(dto.getSkillType())
				.skillRating(dto.getSkillRating())
				.yearOfExperience(dto.getYearOfExperience())
				.employees(new ArrayList<>())
				.build();
	}
			
}
