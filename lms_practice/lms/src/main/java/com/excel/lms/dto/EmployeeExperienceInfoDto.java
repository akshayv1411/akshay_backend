package com.excel.lms.dto;

import java.time.LocalDate;

import com.excel.lms.enums.Designation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeExperienceInfoDto {
	private String companyName;
	private Double yearOfExperience;
	private LocalDate dateOfJoining;
	private LocalDate dateOfRelieving;
	private Designation designation;
	private String location;
}
