package com.excel.lms.service;


import com.excel.lms.dto.EducationListDto;
import com.excel.lms.dto.EmployeeAddressListDto;
import com.excel.lms.dto.EmployeeBankInfoDto;
import com.excel.lms.dto.EmployeeContactInfoListDto;
import com.excel.lms.dto.EmployeeExperienceListDto;
import com.excel.lms.dto.EmployeePrimaryInfoDto;
import com.excel.lms.dto.EmployeeSecondaryInfoDto;
import com.excel.lms.dto.EmployeeTechnicalSkillsListDto;

public interface EmployeeService {

	String addEmployeePrimaryInfo(EmployeePrimaryInfoDto dto);

	String addEmployeeSecondaryInfo(EmployeeSecondaryInfoDto dto);

	String addEmployeeBankInfo(EmployeeBankInfoDto dto);

	String addEmployeeEducationInfo(EducationListDto dto);

	String addEmployeeExperienceInfo(EmployeeExperienceListDto experienceListDto);

	String addAddressInfo(EmployeeAddressListDto addressListDto);

	String addContactInfo(EmployeeContactInfoListDto contactInfoListDto);

	String addSkillsInfo(EmployeeTechnicalSkillsListDto skillsDto);

}