package com.excel.lms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excel.lms.entity.EmployeeAddress;
import com.excel.lms.entity.EmployeePrimaryInfo;
import com.excel.lms.entity.EmployeeSecondaryInfo;

public interface EmployeeRepository extends JpaRepository<EmployeePrimaryInfo, Integer> {

	Optional<EmployeePrimaryInfo> findByEmployeeId(String employeeId);

}
