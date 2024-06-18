package com.excel.ims.utils;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.excel.ims.dto.AdminDto;
import com.excel.ims.dto.InventoryItemsDto;
import com.excel.ims.dto.PurchaseOrderDto;
import com.excel.ims.dto.PurchaseOrderItemsDto;
import com.excel.ims.dto.UserDto;
import com.excel.ims.entity.Admin;
import com.excel.ims.entity.InventoryItems;
import com.excel.ims.entity.PurchaseOrderItems;
import com.excel.ims.entity.PurchaseOrders;
import com.excel.ims.entity.User;

public class ObjectUtils {

	public static User userDtoToEntitiy(UserDto dto) {
	
		return User.builder().username(dto.getUsername())
				.email(dto.getEmail()).password(dto.getPassword())
				.build();
	}

	public static UserDto userEntityToDto(User user) {
	
		return UserDto.builder().userId(user.getUserId())
				.username(user.getUsername()).email(user.getEmail())
				.createdAt(user.getCreatedAt()).password(user.getPassword()).isAdmin(user.isAdmin()).build();
	}

	public static User updateValues(User user, UserDto dto) {
			user.setUsername(dto.getUsername());
			user.setEmail(dto.getEmail());
			user.setPassword(dto.getPassword());
			user.setCreatedAt(LocalDate.now());
			user.setAdmin(user.isAdmin());
			return user;
	}

	public static List<PurchaseOrders> ordersDtoToEntity(List<PurchaseOrderDto> orders) {
	
		return orders.stream().map(order->PurchaseOrders.builder()
				.supplier(order.getSupplier()).status(order.getStatus())
				.build()).collect(Collectors.toList());
	}

	public static InventoryItems itemsDtoToEntity(InventoryItemsDto dto) {
		
		return InventoryItems .builder().itemName(dto.getItemName()).description(dto.getDescription())
				.category(dto.getCategory()).unitPrice(dto.getUnitPrice())
				.quantityOnHand(dto.getQuantityOnHand())
				.reorderPoint(dto.getReorderPoint()).createdAt(dto.getCreatedAt()).build();
	}

	public static List<PurchaseOrderItems> orderItemsDtoToEntity(List<PurchaseOrderItemsDto> orderItems) {
	
		return orderItems.stream().map(m->PurchaseOrderItems.builder()
				.quantity(m.getQuantity()).unitPrice(m.getUnitPrice()).build()).collect(Collectors.toList());
	}

	public static InventoryItemsDto itemsEntityToDto(InventoryItems items) {
		
		return InventoryItemsDto.builder().itemId(items.getItemId()).itemName(items.getItemName())
				.description(items.getDescription()).category(items.getCategory())
				.unitPrice(items.getUnitPrice()).reorderPoint(items.getReorderPoint())
				.quantityOnHand(items.getQuantityOnHand()).build();
	}

	public static InventoryItems updateValues(InventoryItems item, InventoryItems dto) {
		item.setItemName(dto.getItemName());
		item.setDescription(dto.getDescription());
//		item.setCreatedAt(LocalDate.now());
		item.setCategory(dto.getCategory());
		item.setUnitPrice(dto.getUnitPrice());
		item.setReorderPoint(dto.getReorderPoint());
		item.setQuantityOnHand(dto.getQuantityOnHand());
		return item;
	}

	public static PurchaseOrders updateValues(PurchaseOrders order, PurchaseOrderDto dto) {
		order.setSupplier(dto.getSupplier());
		order.setStatus(dto.getStatus());
		return order;
	}

	public static PurchaseOrderDto orderEntityToDto(PurchaseOrders save) {
		
		return PurchaseOrderDto.builder().createdAt(save.getCreatedAt()).orderDate(save.getOrderDate())
				.status(save.getStatus()).supplier(save.getSupplier()).orderId(save.getOrderId()).build();
	}

	public static Admin itemsDtoToEntity(AdminDto dto) {
			return Admin.builder().adminame(dto.getAdminame()).adminId(dto.getAdminId())
					.email(dto.getEmail()).password(dto.getPassword()).build();
	}


	public static PurchaseOrderItems updateValues(PurchaseOrderItems orderItems, PurchaseOrderItemsDto dto) {
		 	orderItems.setQuantity(dto.getQuantity());
		 	orderItems.setUnitPrice(dto.getUnitPrice());
		return orderItems;
	}

	public static PurchaseOrderItemsDto orderItemsEntityToDto(PurchaseOrderItems save) {
	
		return PurchaseOrderItemsDto.builder().orderItemId(save.getOrderItemId())
				.unitPrice(save.getUnitPrice()).quantity(save.getQuantity()).build();
	}

	
}



