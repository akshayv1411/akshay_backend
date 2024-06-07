package com.excel.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excel.lms.entity.EmployeeExperienceInfo;

public interface ExperienceRepository extends JpaRepository<EmployeeExperienceInfo, Integer> {
	

}
