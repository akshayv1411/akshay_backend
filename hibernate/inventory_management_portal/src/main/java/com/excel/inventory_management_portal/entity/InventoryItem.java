package com.excel.inventory_management_portal.entity;

@Entity
@Getter
@Setter
public class InventoryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;
    private String name;
    private String description;
    private String category;
    private double unitPrice;
    private int quantityOnHand;
    private int reorderPoint;
    private Date createdAt;
}
