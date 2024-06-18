package com.excel.ims.entity;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Entity
public class PurchaseOrderItems {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer orderItemId;
	
private String quantity;

private Double unitPrice;
@JoinColumn(name="purchaseOrder_id")
@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
private PurchaseOrders purchaseOrder;

@JoinColumn(name="inventoryItem_id")
@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
private InventoryItems inventoryItem;
}
