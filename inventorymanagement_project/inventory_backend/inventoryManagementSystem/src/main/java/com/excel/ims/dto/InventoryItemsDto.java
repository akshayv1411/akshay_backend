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
public class InventoryItemsDto {
	
	private Integer itemId;
	private String itemName;
	private String description;
	private String category;
	private String unitPrice;
	private String quantityOnHand;
	private String reorderPoint;
	private LocalDate createdAt;
}
