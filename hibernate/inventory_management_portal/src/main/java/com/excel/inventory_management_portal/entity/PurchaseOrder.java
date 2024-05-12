package com.excel.inventory_management_portal.entity;

@Entity
@Getter
@Setter
public class PurchaseOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String supplier;
    private Date orderDate;
    private String status;
    private Date createdAt;
}