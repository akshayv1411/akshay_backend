package com.excel.ims.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excel.ims.entity.PurchaseOrders;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrders, Integer>{
Optional<PurchaseOrders> findBySupplier(String supplier);
Optional<PurchaseOrders> findByOrderId(Integer orderId);
}
