package com.excel.lms.entity;

import com.excel.lms.enums.Account;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "employee_bank_info")
public class EmployeeBankInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bank_id")
	private Integer bankId;
	
	@Column(name = "account_no")
	private Long accountNo;
	private String bankName;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "account_type")
	private Account accountType;
	
	@Column(name = "ifsc_code")
	private String ifscCode;
	private String branch;
	private String state;

	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "employeBankInfo")
	private EmployeePrimaryInfo employeePrimaryInfo;
}
