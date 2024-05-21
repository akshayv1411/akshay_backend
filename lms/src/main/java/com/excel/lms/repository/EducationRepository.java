package com.excel.lms.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.excel.lms.entity.EmployeeEducationDetails;
public interface EducationRepository extends JpaRepository<EmployeeEducationDetails, Integer>{
	
}
