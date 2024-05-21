package com.excel.lms.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excel.lms.dto.EducationListDto;
import com.excel.lms.dto.EmployeeAddressListDto;
import com.excel.lms.dto.EmployeeBankInfoDto;
import com.excel.lms.dto.EmployeeContactInfoListDto;
import com.excel.lms.dto.EmployeeExperienceListDto;
import com.excel.lms.dto.EmployeePrimaryInfoDto;
import com.excel.lms.dto.EmployeeSecondaryInfoDto;
import com.excel.lms.dto.EmployeeTechnicalSkillsListDto;
import com.excel.lms.entity.EmployeeAddress;
import com.excel.lms.entity.EmployeeBankInfo;
import com.excel.lms.entity.EmployeeContactInfo;
import com.excel.lms.entity.EmployeeEducationDetails;
import com.excel.lms.entity.EmployeeExperienceInfo;
import com.excel.lms.entity.EmployeePrimaryInfo;
import com.excel.lms.entity.EmployeeSecondaryInfo;
import com.excel.lms.entity.EmployeeTechnicalSkill;
import com.excel.lms.repository.EducationRepository;
import com.excel.lms.repository.EmployeeAddressRepository;
import com.excel.lms.repository.EmployeeContactRepository;
import com.excel.lms.repository.EmployeeExperienceRepository;
import com.excel.lms.repository.EmployeeRepository;
import com.excel.lms.repository.SkillsRepository;
import com.excel.lms.service.EmployeeService;
import com.excel.lms.util.EmployeeUtil;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private EducationRepository educationResitory;

	@Autowired
	private EmployeeExperienceRepository employeeExperienceRepository;

	@Autowired
	private EmployeeAddressRepository addressRepository;

	@Autowired
	private EmployeeContactRepository contactRepository;

	@Autowired
	private SkillsRepository skillsRepository;

	@Override
	public String addEmployeePrimaryInfo(EmployeePrimaryInfoDto dto) {
		EmployeePrimaryInfo employeePrimaryInfo = EmployeeUtil.employeePrimaryInfoDtoToEntity(dto);
		return employeeRepository.save(employeePrimaryInfo).getEmployeeId();
	}

	@Override
	public String addEmployeeSecondaryInfo(EmployeeSecondaryInfoDto dto) {
		Optional<EmployeePrimaryInfo> optional = employeeRepository.findByEmployeeId(dto.getEmployeeId());
		if (optional.isPresent()) {
			EmployeePrimaryInfo employee = optional.get();
			EmployeeSecondaryInfo employeeSecondaryInfo = EmployeeUtil.employeeSecondaryInfoDtoToEntity(dto);
			if (employee.getSecondary() == null) {
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

	@Override
	public String addEmployeeBankInfo(EmployeeBankInfoDto dto) {
		Optional<EmployeePrimaryInfo> optional = employeeRepository.findByEmployeeId(dto.getEmployeeId());
		if (optional.isPresent()) {
			EmployeePrimaryInfo employee = optional.get();
			EmployeeBankInfo employeeBankInfo = EmployeeUtil.employeeBankInfoDtoToEntity(dto);
			if (employee.getBankInfo() == null) {
				employee.setBankInfo(employeeBankInfo);
				employeeBankInfo.setEmployee(employee);
			} else {
				EmployeeBankInfo bankInfo = employee.getBankInfo();
				bankInfo.setAccountNo(dto.getAccountNo());
				bankInfo.setBankName(dto.getBankName());
				bankInfo.setAccountType(dto.getAccountType());
				bankInfo.setIfscCode(dto.getIfscCode());
				bankInfo.setBranch(dto.getBranch());
				bankInfo.setState(dto.getState());
			}
			return employeeRepository.save(employee).getEmployeeId();
		}
		return null;
	}

	@Override
	public String addEmployeeEducationInfo(EducationListDto dto) {
		Optional<EmployeePrimaryInfo> employeeOptional = employeeRepository.findByEmployeeId(dto.getEmployeeId());

		if (employeeOptional.isPresent()) {
			EmployeePrimaryInfo employee = employeeOptional.get();
			List<EmployeeEducationDetails> educations = EmployeeUtil
					.employeeEducationDetailsDtoToEntity(dto.getEducations());

			if (employee.getEducation() != null) {
				employee.getEducation().stream().forEach(edu -> educationResitory.delete(edu));
			}

			educations.stream().forEach(edu -> edu.setEmployee(employee));
			employee.setEducation(educations);
			return employeeRepository.save(employee).getEmployeeId();
		}

		return null;
	}

	@Override
	public String addEmployeeExperienceInfo(EmployeeExperienceListDto experienceListDto) {
		Optional<EmployeePrimaryInfo> employeeOptional = employeeRepository
				.findByEmployeeId(experienceListDto.getEmployeeId());

		if (employeeOptional.isPresent()) {
			EmployeePrimaryInfo employee = employeeOptional.get();
			List<EmployeeExperienceInfo> experiences = EmployeeUtil
					.employeeExperienceInfoDtoToEntity(experienceListDto.getExperiences());

			if (employee.getEmployeeExperience() != null) {
				employee.getEmployeeExperience().stream().forEach(ex -> employeeExperienceRepository.delete(ex));
			}

			experiences.stream().forEach(ex -> ex.setEmployee(employee));
			employee.setEmployeeExperience(experiences);
			return employeeRepository.save(employee).getEmployeeId();
		}
		return null;
	}

	@Override
	public String addAddressInfo(EmployeeAddressListDto addressListDto) {
		Optional<EmployeePrimaryInfo> employeeOptional = employeeRepository
				.findByEmployeeId(addressListDto.getEmployeeId());

		if (employeeOptional.isPresent()) {
			EmployeePrimaryInfo employee = employeeOptional.get();
			List<EmployeeAddress> allAdrress = EmployeeUtil
					.employeeAddreessInfoDtoToEntity(addressListDto.getAllAdrress());

			if (employee.getEmployeeAddress() != null) {
				employee.getEmployeeAddress().stream().forEach(ad -> addressRepository.delete(ad));
			}

			allAdrress.stream().forEach(ad -> ad.setEmployee(employee));
			employee.setEmployeeAddress(allAdrress);
			return employeeRepository.save(employee).getEmployeeId();
		}
		return null;
	}

	@Override
	public String addContactInfo(EmployeeContactInfoListDto contactInfoListDto) {
		Optional<EmployeePrimaryInfo> employeeOptional = employeeRepository
				.findByEmployeeId(contactInfoListDto.getEmployeeId());

		if (employeeOptional.isPresent()) {
			EmployeePrimaryInfo employee = employeeOptional.get();
			List<EmployeeContactInfo> contacts = EmployeeUtil
					.employeeContactInfoDtoToEntity(contactInfoListDto.getContacts());

			if (employee.getContactInfo() != null) {
				employee.getContactInfo().stream().forEach(con -> contactRepository.delete(con));
			}

			contacts.stream().forEach(con -> con.setEmployee(employee));
			employee.setContactInfo(contacts);
			return employeeRepository.save(employee).getEmployeeId();
		}

		return null;
	}

	@Override
	public String addSkillsInfo(EmployeeTechnicalSkillsListDto skillsDto) {
		Optional<EmployeePrimaryInfo> employeeOptional = employeeRepository.findByEmployeeId(skillsDto.getEmployeeId());
		if (employeeOptional.isPresent()) {
			EmployeePrimaryInfo employee = employeeOptional.get();
			List<EmployeeTechnicalSkill> skills = skillsDto.getSkills().stream().map(skill -> {
				Optional<EmployeeTechnicalSkill> optional = skillsRepository
						.findBySkillTypeAndSkillRatingAndYearOfExperience(skill.getSkillType(), skill.getSkillRating(),
								skill.getYearOfExperience());
				return optional.isPresent() ? optional.get()
						: EmployeeUtil.employeeTechnicalSkillsInfoDtoToEntity(skill);
			}).collect(Collectors.toList());
			
			
			if(employee.getEmployeeSkill() != null) {
				employee.getEmployeeSkill().clear();
			}
			
			skills.stream().forEach(s -> {
				if (!s.getEmployees().contains(employee))s.getEmployees().add(employee);
			});
			
			employee.setEmployeeSkill(skills);
			employeeRepository.save(employee);
			return employee.getEmployeeId();
			
		}

		return null;
	}
}
