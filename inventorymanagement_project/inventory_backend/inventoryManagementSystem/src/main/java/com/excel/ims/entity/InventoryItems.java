package com.excel.ims.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
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
public class InventoryItems {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer itemId;
	@Column(unique=true)
private String itemName;
private String description;
private String category;
private String unitPrice;
private String quantityOnHand;
private String reorderPoint;
private LocalDate createdAt;
@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "inventoryItem")
private List<PurchaseOrderItems> purchaseOrdersItems;
@PrePersist
protected void onCreate() {
    createdAt = LocalDate.now();
	
}
}
