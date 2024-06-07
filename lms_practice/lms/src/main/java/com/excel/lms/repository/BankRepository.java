package com.excel.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excel.lms.dto.EmployeeBankInfoDto;
import com.excel.lms.entity.EmployeeBankInfo;

public interface BankRepository extends JpaRepository<EmployeeBankInfo, Integer> {

}
