package com.excel.lms.service;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.startup.ListenerCreateRule.OptionalListener;
import org.hibernate.query.NativeQuery.ReturnableResultNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import com.excel.lms.entity.EmployeeAddress;
import com.excel.lms.entity.EmployeeBankInfo;
import com.excel.lms.entity.EmployeeContactInfo;
import com.excel.lms.entity.EmployeeEducationDetails;
import com.excel.lms.entity.EmployeeExperienceInfo;
import com.excel.lms.entity.EmployeePrimaryInfo;
import com.excel.lms.entity.EmployeeSecondaryInfo;
import com.excel.lms.repository.AddressRepository;
import com.excel.lms.repository.BankRepository;
import com.excel.lms.repository.ContactRepository;
import com.excel.lms.repository.EducationRepository;
import com.excel.lms.repository.EmployeeRepository;
import com.excel.lms.repository.ExperienceRepository;
import com.excel.lms.repository.SecondaryRepository;
import com.excel.lms.util.ObjectUtil;
@Service
public class EmployeeServiceImpl implements EmployeeService {


	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EducationRepository educationRepository;
	
	@Autowired
	private ExperienceRepository experienceRepository;
	
	@Autowired 
	private AddressRepository addressRepository;
	
	@Autowired
	private ContactRepository contactRepository;
	
	@Autowired
	private SecondaryRepository secondaryRepository;
	
	@Autowired
	private BankRepository bankRepository; 
	
	@Override
	public String savePrimary(EmployeePrimaryInfoDto dto) {
		if(!employeeRepository.findByEmployeeId(dto.getEmployeeId()).isPresent()) {
			EmployeePrimaryInfo emp	= ObjectUtil.dtoToEntity(dto);
			EmployeePrimaryInfo employeePrimaryInfo = employeeRepository.save(emp);
			return employeePrimaryInfo.getEmployeeId();
		}
		return null;
	}
	@Override
	public String saveSecondary(EmployeeSecondaryInfoDto dto) {
		Optional<EmployeePrimaryInfo>optional = employeeRepository.findByEmployeeId(dto.getEmployeeId());
		if(optional.isPresent()) {
			EmployeePrimaryInfo	employeePrimaryInfo = optional.get();

			if(employeePrimaryInfo.getEmployeeSecondaryInfo() == null ) {
				EmployeeSecondaryInfo employeeSecondaryInfo	= ObjectUtil.dtoToSecondaryEntity(dto);
				employeePrimaryInfo.setEmployeeSecondaryInfo(employeeSecondaryInfo);
				employeeSecondaryInfo.setEmployeePrimaryInfo(employeePrimaryInfo);
				return employeeRepository.save(employeePrimaryInfo).getEmployeeId();
			}
			else {
			EmployeeSecondaryInfo employeeSecondaryInfo = employeePrimaryInfo.getEmployeeSecondaryInfo();
			employeeSecondaryInfo.setPan(dto.getPan());
			employeeSecondaryInfo.setFatherName(dto.getFatherName());
			employeeSecondaryInfo.setMotherName(dto.getMotherName());
			employeeSecondaryInfo.setMaritalStatus(dto.getMariatlStatus());
			employeeSecondaryInfo.setSpouse(dto.getSpouse());
			employeeSecondaryInfo.setAadhar(dto.getAadhar());
			return employeeRepository.save(employeePrimaryInfo).getEmployeeId();
			}
		}
		return null;
		
		

	}
	@Override
	public String saveBankInfo(EmployeeBankInfoDto dto) {
		Optional<EmployeePrimaryInfo>optional = employeeRepository.findByEmployeeId(dto.getEmployeeId());
		if(optional.isPresent()) {
			EmployeePrimaryInfo employeePrimaryInfo = optional.get();
			
			if(employeePrimaryInfo.getEmployeBankInfo() == null) {
				EmployeeBankInfo employeeBankInfo = ObjectUtil.dtoToBankEntity(dto);
				employeePrimaryInfo.setEmployeBankInfo(employeeBankInfo);
				employeeBankInfo.setEmployeePrimaryInfo(employeePrimaryInfo);
				return employeeRepository.save(employeePrimaryInfo).getEmployeeId();						
			}
			else {
				EmployeeBankInfo employeeBankInfo =employeePrimaryInfo.getEmployeBankInfo();
				employeeBankInfo.setAccountNo(dto.getAccountNo());
				employeeBankInfo.setAccountType(dto.getAccountType());
				employeeBankInfo.setBankName(dto.getBankName());
				employeeBankInfo.setBranch(dto.getBranch());
				employeeBankInfo.setIfscCode(dto.getIfscCode());
				employeeBankInfo.setState(dto.getState());
			}
			
		}
		return null;
	}
	@Override
	public String saveEducation(EmployeeEducationListDto dto) {
		Optional<EmployeePrimaryInfo>optional = employeeRepository.findByEmployeeId(dto.getEmployeeId());
		if(optional.isPresent()) {
			EmployeePrimaryInfo employeePrimaryInfo = optional.get();
		List<EmployeeEducationDetails> educations = ObjectUtil.dtoToEducationList(dto.getEmployeeDtos());
			if(employeePrimaryInfo.getEmployeeEducationDetails() != null ) {
				employeePrimaryInfo.getEmployeeEducationDetails().stream()
				.forEach(edu -> educationRepository.delete(edu) );
			}
			educations.stream().forEach(x -> x.setEmployeePrimaryInfo(employeePrimaryInfo));
			employeePrimaryInfo.setEmployeeEducationDetails(educations);
			employeeRepository.save(employeePrimaryInfo);
			return employeePrimaryInfo.getEmployeeId();
		}	
		return null;
	}
	@Override
	public String saveExperience(EmployeeExperienceListDto dto) {
		Optional<EmployeePrimaryInfo>optional = employeeRepository.findByEmployeeId(dto.getEmployeeId());
		if(optional.isPresent()) {
			EmployeePrimaryInfo employeePrimaryInfo = optional.get();
			List<EmployeeExperienceInfo> experience = ObjectUtil.dtoToExperienceList(dto.getExperiences());
			if(employeePrimaryInfo.getEmployeeExperienceInfo() != null ) {
				employeePrimaryInfo.getEmployeeExperienceInfo().stream()
				.forEach(exp -> experienceRepository.delete(exp));
			}
			experience.stream().forEach(x -> x.setEmployeePrimaryInfo(employeePrimaryInfo));
			employeePrimaryInfo.setEmployeeExperienceInfo(experience);
			employeeRepository.save(employeePrimaryInfo);
			return employeePrimaryInfo.getEmployeeId();
		}
		return null;
	}
	@Override
	public String saveAddress(EmployeeAddressListDto dto) {
		Optional<EmployeePrimaryInfo>optional = employeeRepository.findByEmployeeId(dto.getEmployeeId());
		if(optional.isPresent()) {
			EmployeePrimaryInfo employeePrimaryInfo = optional.get();
			List<EmployeeAddress> address = ObjectUtil.dtoToEmployeeAddresses(dto.getAllAdrress());
			if(employeePrimaryInfo.getEmployeeAddresses() != null ) {
				employeePrimaryInfo.getEmployeeAddresses().stream()
				.forEach(add -> addressRepository.delete(add));
			}
			address.stream().forEach(y -> y.setEmployeePrimaryInfo(employeePrimaryInfo));
			employeePrimaryInfo.setEmployeeAddresses(address);
			employeeRepository.save(employeePrimaryInfo);
			return employeePrimaryInfo.getEmployeeId();
		}
		return null;
	}
	@Override
	public String saveContactInfo(EmployeeContactInfoListDto dto) {
		Optional<EmployeePrimaryInfo>optional = employeeRepository.findByEmployeeId(dto.getEmployeeId());
		if(optional.isPresent()) {
			EmployeePrimaryInfo employeePrimaryInfo = optional.get();
			List<EmployeeContactInfo> contact = ObjectUtil.dtoToContactInfos(dto.getContacts());
			if(employeePrimaryInfo.getEmployeeContactInfos() != null ) {
				employeePrimaryInfo.getEmployeeContactInfos().stream()
				.forEach(c -> contactRepository.delete(c));
			}
			contact.stream().forEach(y -> y.setEmployeePrimaryInfo(employeePrimaryInfo));
			employeePrimaryInfo.setEmployeeContactInfos(contact);
			employeeRepository.save(employeePrimaryInfo);
			return employeePrimaryInfo.getEmployeeId();
		}
		return null;
	}
	@Override
	public List<EmployeeSecondaryInfoDto> findSecondaryInfo() {
		
		return secondaryRepository.findAll().stream().map(e -> EmployeeSecondaryInfoDto.builder()
				.pan(e.getPan())
				.aadhar(e.getAadhar())
				.fatherName(e.getFatherName())
				.motherName(e.getMotherName())
				.spouse(e.getSpouse())
				.passportNo(e.getPassportNo())
				.mariatlStatus(e.getMaritalStatus())
				.employeeId(e.getEmployeePrimaryInfo().getEmployeeId())
				.build())
				.toList();
				
	}
	@Override
	public List<EmployeeBankInfoDto> findBankInfo() {
		
		return bankRepository.findAll().stream().map(e-> EmployeeBankInfoDto.builder()
		
				.accountNo(e.getAccountNo())
				.bankName(e.getBankName())
				.accountType(e.getAccountType())
				.ifscCode(e.getIfscCode())
				.branch(e.getBranch())
				.state(e.getState())
				.employeeId(e.getEmployeePrimaryInfo().getEmployeeId())
				.build()).toList();
	}
	
	
	@Override
	public List<EmployeePrimaryInfoDto> getAllPrimaryInfo() {
		
		return employeeRepository.findAll().stream().map(f -> EmployeePrimaryInfoDto.builder()
				.employeeId(f.getEmployeeId())
				.employeeName(f.getEmployeeName())
				.employeeStatus(f.getEmployeeStatus())
				.dateOfBirth(f.getDateOfBirth())
				.dateOfJoining(f.getDateOfJoining())
				.designation(f.getDesignation())
				.email(f.getEmail())
				.bloodGroup(f.getBloodGroup())
				.gender(f.getGender())
				.nationality(f.getNationality())
				.build()).toList();
							
	}
	
	@Override
	public List<EmployeeContactInfoDto> getAllContactInfo(){
		
		return contactRepository.findAll().stream().map(g -> EmployeeContactInfoDto.builder()
				.contactNumber(g.getContactNumber())
				.contactType(g.getContactType())
				.employeeId(g.getEmployeePrimaryInfo().getEmployeeId())
				.build()).toList();
	}
	
	@Override
	public List<EmployeeEducationDetailsDto> getAllEducationInfo() {
		return educationRepository.findAll().stream().map(h -> EmployeeEducationDetailsDto.builder()
				.educationType(h.getEducationType())
				.percentage(h.getPercentage())
				.state(h.getState())
				.universityName(h.getUniversityName())
				.specialization(h.getSpecialization())
				.yearOfPassing(h.getYearOfPassing())
				.employeeId(h.getEmployeePrimaryInfo().getEmployeeId())
				.build()).toList();
	}
	
	@Override
	public List<EmployeeExperienceInfoDto> getAllExperienceInfo() {
		return experienceRepository.findAll().stream().map(h -> EmployeeExperienceInfoDto.builder()
				.companyName(h.getCompanyName())
				.dateOfJoining(h.getDateOfJoining())
				.yearOfExperience(h.getYearOfExperience())
				.dateOfRelieving(h.getDateOfRelieving())
				.designation(h.getDesignation())
				.location(h.getLocation())
				.build()).toList();
	}

	
	@Override
	public EmployeeSecondaryInfoDto updateSecondaryInfo(EmployeeSecondaryInfoDto dto) {
	Optional<EmployeeSecondaryInfo> employeeSecondaryInfo	=secondaryRepository.findByEmployeeSecondaryNumber(dto.getEmployeeSecondaryNumber());
	if(employeeSecondaryInfo.isPresent()) {
		EmployeeSecondaryInfo employeeSecondary = employeeSecondaryInfo.get();
		EmployeeSecondaryInfo emp = ObjectUtil.updateSecondary(dto,employeeSecondary);
		EmployeeSecondaryInfo save = secondaryRepository.save(emp);
		return ObjectUtil.entityToSecondaryDto(save);
		
	}
		return null;
	}
	@Override
	public String deleteSecondaryInfo(EmployeeSecondaryInfoDto dto) {
		Optional<EmployeeSecondaryInfo> employeeSecondaryInfo = secondaryRepository.findByEmployeeSecondaryNumber(dto.getEmployeeSecondaryNumber());
		if(employeeSecondaryInfo.isPresent()) {
			EmployeeSecondaryInfo employeeSecondary = employeeSecondaryInfo.get(); 
			secondaryRepository.delete(employeeSecondary);
			return "secondaryInfo deleted successfully";
			}
		return null;
	}


	
}	
		
	



