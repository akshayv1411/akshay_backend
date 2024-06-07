package com.excel.lms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excel.lms.entity.EmployeeSecondaryInfo;

public interface SecondaryRepository extends JpaRepository<EmployeeSecondaryInfo, Integer> {
	
	Optional<EmployeeSecondaryInfo> findByEmployeeSecondaryNumber(Integer EmployeeSecondaryNumber);

}
