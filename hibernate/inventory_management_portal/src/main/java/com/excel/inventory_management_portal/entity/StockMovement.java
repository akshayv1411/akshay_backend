package com.excel.inventory_management_portal.entity;

@Entity
@Getter
@Setter
public class StockMovement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movementId;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private InventoryItem item;

    private String movementType;
    private int quantity;
    private Date movementDate;
    private String notes;
}