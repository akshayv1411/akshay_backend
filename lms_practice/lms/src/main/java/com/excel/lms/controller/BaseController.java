
package com.excel.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
import com.excel.lms.entity.EmployeePrimaryInfo;
import com.excel.lms.entity.EmployeeSecondaryInfo;
import com.excel.lms.response.CommonResponse;
import com.excel.lms.service.EmployeeService;
import com.fasterxml.jackson.core.ErrorReportConfiguration.Builder;

@RestController
@RequestMapping(path="/api/v1/employee")
public class BaseController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping(path= "/pinfo")
	public ResponseEntity<CommonResponse<String>> postPrimaryInfo(@RequestBody EmployeePrimaryInfoDto dto){
		String save = employeeService.savePrimary(dto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(CommonResponse.<String>builder().data(save).isError(false).message("Employee_info_saved").build());

	}

	@PostMapping(path= "/secondaryinfo")
	public ResponseEntity<CommonResponse<String>> postSecondaryInfo(@RequestBody EmployeeSecondaryInfoDto dto){
		String save = employeeService.saveSecondary(dto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(CommonResponse.<String>builder().data(save).isError(false).message("Employee_secondaryInfo_saved").build());
	}

	@PostMapping(path = "/bankinfo")
	public ResponseEntity<CommonResponse<String>> postBankInfo (@RequestBody EmployeeBankInfoDto dto){
		String save = employeeService.saveBankInfo(dto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(CommonResponse.<String>builder().data(save).isError(false).message("employee_bank_info_added_successfully").build());

	}

	@PostMapping(path = "/educationinfo")
	public ResponseEntity<CommonResponse<String>> postEducationInfo (@RequestBody EmployeeEducationListDto dto ){
		String save = employeeService.saveEducation(dto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(CommonResponse.<String>builder().data(save).isError(false).message("employee_education_info_added_successfully").build());

	}

	@PostMapping(path = "/experienceinfo")
	public ResponseEntity<CommonResponse<String>> postExperienceInfo (@RequestBody EmployeeExperienceListDto dto){
		String save = employeeService.saveExperience(dto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(CommonResponse.<String>builder().data(save).isError(false).message("employee_experience_info_added_successfully").build());
	}
	
	@PostMapping(path = "/Addressinfo")
	public ResponseEntity<CommonResponse<String>> postAddressInfo (@RequestBody EmployeeAddressListDto dto){
		String save = employeeService.saveAddress(dto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(CommonResponse.<String>builder().data(save).isError(false).message("employee_address_added").build());
	}
	
	@PostMapping(path = "/AddContactInfo")
	public ResponseEntity<CommonResponse<String>> postContactInfo (@RequestBody EmployeeContactInfoListDto dto){
		String save = employeeService.saveContactInfo(dto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(CommonResponse.<String>builder().data(save).isError(false).message("employee_contact_saved").build());
//----------------------------------------------------------------------------------------------------------------------------------------------------------				
	}
	
	@GetMapping(path = "/getsecondary")
	public ResponseEntity<CommonResponse<List<EmployeeSecondaryInfoDto>>> getSecondaryInfo(){
	List<EmployeeSecondaryInfoDto> getall	= employeeService.findSecondaryInfo();
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(CommonResponse.<List<EmployeeSecondaryInfoDto>>builder()
				.data(getall)
				.isError(false)
				.message("Get all Sucessfully")
				.build());
	}
	
	@GetMapping(path = "/getAllPrimaryInfo")
	public ResponseEntity<CommonResponse<List<EmployeePrimaryInfoDto>>> getallPrimaryInfo(){
		List<EmployeePrimaryInfoDto> getall = employeeService.getAllPrimaryInfo();
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(CommonResponse.<List<EmployeePrimaryInfoDto>>builder()
				.data(getall)
				.isError(false)
				.message("entire primary info fetched successfully")
				.build());
	}
	
	
	
	@GetMapping(path = "/getBankInfo")
	public ResponseEntity<CommonResponse<List<EmployeeBankInfoDto>>> getallBankInfo(){
		List<EmployeeBankInfoDto> getall = employeeService.findBankInfo();
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(CommonResponse.<List<EmployeeBankInfoDto>>builder()
				.data(getall)
				.isError(false)
				.message("Bank info Successfully")
				.build());
	}
	
	@GetMapping(path = "/getAllContactInfo")
	public ResponseEntity<CommonResponse<List<EmployeeContactInfoDto>>> getallContactInfo(){
		List<EmployeeContactInfoDto> getall = employeeService.getAllContactInfo();
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(CommonResponse.<List<EmployeeContactInfoDto>>builder()
				.data(getall)
				.isError(false)
				.message("all Contact info fetched successfully")
				.build());
	}
	
	@GetMapping(path = "/getAllExperienceInfo")
	public ResponseEntity<CommonResponse<List<EmployeeExperienceInfoDto>>> getallExperienceInfo(){
		List<EmployeeExperienceInfoDto> getall = employeeService.getAllExperienceInfo();
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(CommonResponse.<List<EmployeeExperienceInfoDto>>builder()
				.data(getall)
				.isError(false)
				.message("experience details fetched")
				.build());
	}
		
	@GetMapping(path = "/geteducationInfo")
	public ResponseEntity<CommonResponse<List<EmployeeEducationDetailsDto>>> getallEducationInfo(){
		List<EmployeeEducationDetailsDto> getall = employeeService.getAllEducationInfo();
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(CommonResponse.<List<EmployeeEducationDetailsDto>>builder()
				.data(getall)
				.isError(false)
				.message("all eductaion info fetched successfully")
				.build());
	}
//---------------------------------------------------------------------------------------------------------------------------------------------------	
	@PutMapping(path = "/updateSecondaryInfo")
	public ResponseEntity<CommonResponse<EmployeeSecondaryInfoDto>> updateSecondaryInfo(@RequestBody EmployeeSecondaryInfoDto dto){
		EmployeeSecondaryInfoDto getall = employeeService.updateSecondaryInfo(dto);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(CommonResponse.<EmployeeSecondaryInfoDto>builder()
				.data(getall)
				.isError(false)
				.message("employee secondary info updated successfully")
				.build());
	}
//----------------------------------------------------------------------------------------------------------------------------------------	
	@DeleteMapping(path = "/deleteSecondaryInfo")
	public ResponseEntity<CommonResponse<String>> deleteSecondaryInfo(@RequestBody EmployeeSecondaryInfoDto dto){
		String delete = employeeService.deleteSecondaryInfo(dto);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(CommonResponse.<String>builder()
				.data(delete)
				.isError(false)
				.message("employee secondary info deleted successfully")
				.build());
	}
}
//-------------------------------------------------------------------------------------------------------------------------------------------------	
