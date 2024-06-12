package com.excel.lms.service;

import java.util.List;

import com.excel.lms.dto.EmployeeAddressDto;
import com.excel.lms.dto.EmployeeAddressListDto;
import com.excel.lms.dto.EmployeeBankInfoDto;
import com.excel.lms.dto.EmployeeContactInfoDto;
import com.excel.lms.dto.EmployeeContactInfoListDto;
import com.excel.lms.dto.EmployeeEducationDetailsDto;
import com.excel.lms.dto.EmployeeEducationListDto;
import com.excel.lms.dto.EmployeeExperienceInfoDto;
import com.excel.lms.dto.EmployeeExperienceListDto;
import com.excel.lms.dto.EmployeePrimaryInfoDto;
import com.excel.lms.dto.EmployeeSecondaryInfoDto;

public interface EmployeeService {

	public String savePrimary(EmployeePrimaryInfoDto dto);

	public String saveSecondary(EmployeeSecondaryInfoDto dto);

	public String saveBankInfo(EmployeeBankInfoDto dto);

	public String saveEducation(EmployeeEducationListDto dto);

	public String saveExperience(EmployeeExperienceListDto dto);

	public String saveAddress(EmployeeAddressListDto dto);

	public String saveContactInfo(EmployeeContactInfoListDto dto);

	public List<EmployeeSecondaryInfoDto> findSecondaryInfo();

	public List<EmployeeBankInfoDto> findBankInfo();

	public EmployeeSecondaryInfoDto updateSecondaryInfo(EmployeeSecondaryInfoDto dto);

	public String deleteSecondaryInfo(EmployeeSecondaryInfoDto dto);

	public List<EmployeePrimaryInfoDto> getAllPrimaryInfo();

	public List<EmployeeContactInfoDto> getAllContactInfo();

	public List<EmployeeEducationDetailsDto> getAllEducationInfo();

	public List<EmployeeExperienceInfoDto> getAllExperienceInfo();

	public List<EmployeeAddressDto> getallAdressInfo();
	
	
	
}
