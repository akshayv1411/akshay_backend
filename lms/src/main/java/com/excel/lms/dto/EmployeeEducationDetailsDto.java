package com.excel.lms.dto;

import java.time.LocalDate;

import com.excel.lms.enums.Education;

import jakarta.persistence.Column;
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
public class EmployeeEducationDetailsDto {
	private Education educationType;
	private LocalDate yearOfPassing;
	private Double percentage;
	private String instituteName;
	private String universityName;
	private String specialization;
	private String state;
}
