package com.excel.ims.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excel.ims.entity.PurchaseOrderItems;



public interface PurchaseOrderItemsRepository extends JpaRepository<PurchaseOrderItems, Integer>{
  Optional<PurchaseOrderItems> findByOrderItemId(Integer orderItemId);
}
