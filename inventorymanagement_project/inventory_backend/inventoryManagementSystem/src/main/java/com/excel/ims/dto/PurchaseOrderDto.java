package com.excel.ims.dto;

import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PurchaseOrderDto {
	private Integer orderId;
	private String supplier;
	private LocalDate orderDate;
	private String status;
	private LocalDate createdAt;
	private String email;
}
