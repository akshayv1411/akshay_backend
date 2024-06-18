package com.excel.ims.service;

import java.util.List;

import com.excel.ims.dto.AdminDto;
import com.excel.ims.dto.InventoryItemsDto;
import com.excel.ims.dto.PurchaseOrderDto;
import com.excel.ims.dto.PurchaseOrderItemsDto;
import com.excel.ims.dto.PurchaseOrderItemsListDto;
import com.excel.ims.dto.PurchaseOrderListDto;
import com.excel.ims.dto.UserDto;
import com.excel.ims.entity.InventoryItems;
import com.excel.ims.entity.PurchaseOrderItems;

public interface InventoryService {

	String addUserInfo(UserDto dto);

	String userLogin(UserDto dto);

	public UserDto userGet(String email);

	UserDto updateUser(UserDto dto);

	String orderAdd(PurchaseOrderListDto dto);

	String inventoryAdd(InventoryItemsDto dto);

	Integer orderItemsAdd(PurchaseOrderItemsListDto dto);

	InventoryItemsDto inventoryItemGet(Integer itemId);

	InventoryItemsDto updateInventoryItems(InventoryItems dto);

	List<UserDto> userGetAll();

	String deleteUser(UserDto dto);

	List<InventoryItemsDto> userGetAllProducts();

	String deleteItem(InventoryItems dto);

	List<PurchaseOrderDto> getALLorders();

	String deleteOrders(PurchaseOrderDto dto);

	List<PurchaseOrderItemsDto> getAllOrdersItems();

	PurchaseOrderDto updateOrder(PurchaseOrderDto dto);

	String adminAdd(AdminDto dto);

	String adminLogin(AdminDto dto);

	PurchaseOrderItemsDto updatePurchaseorderItemDto(PurchaseOrderItemsDto dto);

	



}