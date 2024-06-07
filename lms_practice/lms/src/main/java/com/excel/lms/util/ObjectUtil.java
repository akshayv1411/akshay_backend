package com.excel.lms.util;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.excel.lms.dto.EmployeeAddressDto;
import com.excel.lms.dto.EmployeeAddressListDto;
import com.excel.lms.dto.EmployeeBankInfoDto;
import com.excel.lms.dto.EmployeeContactInfoDto;
import com.excel.lms.dto.EmployeeEducationDetailsDto;
import com.excel.lms.dto.EmployeeExperienceInfoDto;
import com.excel.lms.dto.EmployeePrimaryInfoDto;
import com.excel.lms.dto.EmployeeSecondaryInfoDto;
import com.excel.lms.entity.EmployeeAddress;
import com.excel.lms.entity.EmployeeBankInfo;
import com.excel.lms.entity.EmployeeContactInfo;
import com.excel.lms.entity.EmployeeEducationDetails;
import com.excel.lms.entity.EmployeeExperienceInfo;
import com.excel.lms.entity.EmployeePrimaryInfo;
import com.excel.lms.entity.EmployeeSecondaryInfo;

public class ObjectUtil {

	public static EmployeePrimaryInfo dtoToEntity(EmployeePrimaryInfoDto dto) {
		return EmployeePrimaryInfo.builder().employeeId(dto.getEmployeeId())
				.employeeName(dto.getEmployeeName()).dateOfJoining(dto.getDateOfJoining())
				.dateOfBirth(dto.getDateOfBirth()).bloodGroup(dto.getBloodGroup())
				.designation(dto.getDesignation()).email(dto.getEmail())
				.gender(dto.getGender()).nationality(dto.getNationality())
				.employeeStatus(dto.getEmployeeStatus()).build();
	}

	public static EmployeeSecondaryInfo dtoToSecondaryEntity(EmployeeSecondaryInfoDto dto) {

		return EmployeeSecondaryInfo.builder().pan(dto.getPan()).aadhar(dto.getAadhar())
				.fatherName(dto.getFatherName()).motherName(dto.getMotherName())
				.spouse(dto.getSpouse()).passportNo(dto.getPassportNo()).maritalStatus(dto.getMariatlStatus()).build();	

	}
	
	public static EmployeeBankInfo dtoToBankEntity(EmployeeBankInfoDto dto) {
		return EmployeeBankInfo.builder().accountNo(dto.getAccountNo())
				.bankName(dto.getBankName()).accountType(dto.getAccountType())
				.ifscCode(dto.getIfscCode()).branch(dto.getBranch())
				.state(dto.getState()).build();
		
	}

	public static List<EmployeeEducationDetails> dtoToEducationList(List<EmployeeEducationDetailsDto> employeeDtos) {
		
		return employeeDtos.stream()
				.map(edu -> EmployeeEducationDetails.builder().yearOfPassing(edu.getYearOfPassing())
						.educationType(edu.getEducationType()).specialization(edu.getSpecialization())
						.percentage(edu.getPercentage()).state(edu.getState()).universityName(edu.getUniversityName())
						.build()).collect(Collectors.toList());
	}

	public static List<EmployeeExperienceInfo> dtoToExperienceList(List<EmployeeExperienceInfoDto> experiences) {
		
		return experiences.stream()
				.map(exp -> EmployeeExperienceInfo.builder().companyName(exp.getCompanyName())
						.dateOfJoining(exp.getDateOfJoining()).dateOfRelieving(exp.getDateOfRelieving())
						.yearOfExperience(exp.getYearOfExperience()).designation(exp.getDesignation())
						.location(exp.getLocation()).build()).collect(Collectors.toList());
	}
	
	public static List<EmployeeAddress> dtoToEmployeeAddresses(List<EmployeeAddressDto> address) {
		return address.stream()
				.map(add -> EmployeeAddress.builder().city(add.getCity())
						.doorNo(add.getDoorNo()).street(add.getStreet()).locality(add.getLocality())
						.city(add.getCity()).state(add.getState()).pinCode(add.getPinCode()).addressType(add.getAddressType())
						.landMark(add.getLandMark()).build()).collect(Collectors.toList());
		
	}
	
	public static List<EmployeeContactInfo> dtoToContactInfos(List<EmployeeContactInfoDto> contactInfo) {
		return contactInfo.stream()
				.map(contact -> EmployeeContactInfo.builder().contactType(contact.getContactType())
						.contactNumber(contact.getContactNumber()).build()).collect(Collectors.toList());
	}

	public static EmployeeSecondaryInfo updateSecondary(EmployeeSecondaryInfoDto dto,
			EmployeeSecondaryInfo employeeSecondary) {
		employeeSecondary.setAadhar(dto.getAadhar());
		employeeSecondary.setFatherName(dto.getFatherName());
		employeeSecondary.setMotherName(dto.getMotherName());
		employeeSecondary.setMaritalStatus(dto.getMariatlStatus());
		employeeSecondary.setPan(dto.getPan());
		employeeSecondary.setSpouse(dto.getSpouse());
		employeeSecondary.setPassportNo(dto.getPassportNo());
		return employeeSecondary;
	}

	public static EmployeeSecondaryInfoDto entityToSecondaryDto(EmployeeSecondaryInfo save) {
		
		return EmployeeSecondaryInfoDto.builder()
				.pan(save.getPan())
				.aadhar(save.getAadhar())
				.fatherName(save.getFatherName())
				.motherName(save.getMotherName())
				.spouse(save.getSpouse())
				.passportNo(save.getPassportNo())
				.mariatlStatus(save.getMaritalStatus())
				.build();	

	}
	
	
	
}	
