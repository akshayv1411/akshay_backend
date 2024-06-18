package com.excel.ims.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excel.ims.entity.InventoryItems;

public interface InventoryRepository extends JpaRepository<InventoryItems, Integer> {
	Optional<InventoryItems> findByItemId(Integer itemId);

}
