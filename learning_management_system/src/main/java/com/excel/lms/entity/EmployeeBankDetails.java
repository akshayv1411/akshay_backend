package com.excel.lms.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Table(name = "employee_bank_details")

public class EmployeeBankDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer AccountNo;
	private String BankName;
	private String AccountType;
	private Integer ifsc_code;
	private String Branch;
	private String State;
}
