package com.excel.ims.dto;

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
public class PurchaseOrderItemsDto {
	private Integer orderItemId;
	private String quantity;
	private Double unitPrice;
	private String itemName;
	private Integer orderId;
}
