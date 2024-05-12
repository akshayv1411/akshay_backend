package com.excel.inventory_management_portal.entity;

@Entity
@Getter
@Setter
public class PurchaseOrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItemId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private PurchaseOrder order;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private InventoryItem item;

    private int quantity;
    private double unitPrice;
}