package com.excel.ims.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.excel.ims.commomrespose.CommonResponse;
import com.excel.ims.dto.AdminDto;
import com.excel.ims.dto.InventoryItemsDto;
import com.excel.ims.dto.PurchaseOrderDto;
import com.excel.ims.dto.PurchaseOrderItemsDto;
import com.excel.ims.dto.PurchaseOrderItemsListDto;
import com.excel.ims.dto.PurchaseOrderListDto;
import com.excel.ims.dto.UserDto;
import com.excel.ims.entity.InventoryItems;
import com.excel.ims.service.InventoryService;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/v1/inventory", method = { RequestMethod.POST, RequestMethod.PUT })
public class InventroryController {
	@Autowired
	private InventoryService inventoryService;

	@PostMapping(path = "/user/register")
	ResponseEntity<CommonResponse<String>> addUserInfo(@RequestBody UserDto dto) {
		String userAdded = inventoryService.addUserInfo(dto);
		return ResponseEntity.status(HttpStatus.OK).body(
				CommonResponse.<String>builder().data(userAdded).message("User_INFO_SAVED").isError(false).build());
	}

	@PostMapping(path = "/user/login")
	ResponseEntity<CommonResponse<String>> userLogin(@RequestBody UserDto dto) {
		String userAdded = inventoryService.userLogin(dto);
		return ResponseEntity.status(HttpStatus.OK).body(
				CommonResponse.<String>builder().data(userAdded).message("Login Successfull").isError(false).build());
	}

	@GetMapping(path = "/user/get")
	ResponseEntity<CommonResponse<UserDto>> userGet(@RequestParam(name="email")String email) {
		UserDto userfetch = inventoryService.userGet(email);
		return ResponseEntity.status(HttpStatus.OK).body(CommonResponse.<UserDto>builder().data(userfetch)
				.message("fetchinig  Successfull").isError(false).build());
	}

	@PutMapping(path = "/user/put")
	public ResponseEntity<CommonResponse<UserDto>> updateUser(@RequestBody UserDto dto) {
		UserDto updatedUser = inventoryService.updateUser(dto);
		return ResponseEntity.status(HttpStatus.OK).body(CommonResponse.<UserDto>builder().data(updatedUser)
				.isError(false).message("USER_UPDATE_SUCCESS").build());
	}
	@GetMapping(path = "/user/getall")
	ResponseEntity<CommonResponse<List<UserDto>>> userGetAll(){
		List<UserDto> allUsers=inventoryService.userGetAll();
		return ResponseEntity.status(HttpStatus.OK).body(CommonResponse.<List<UserDto>>builder().data(allUsers)
				 .isError(false).message("ALL_USERS_FETCHED_SUCCESSFULLY").build());
	}
	@DeleteMapping(path = "/user/delete")
	ResponseEntity<CommonResponse<String>> deleteUser(@RequestBody UserDto dto){
		String userDelete=inventoryService.deleteUser(dto);
		return ResponseEntity.status(HttpStatus.OK).body(CommonResponse.<String>builder()
				.isError(false).data(userDelete).message("USER_DELETED_SUCCESS").build());
	}
	
	@CrossOrigin("*")
	@PostMapping(path = "/orderlist")
	ResponseEntity<CommonResponse<String>> orderAdd(@RequestBody PurchaseOrderListDto dto) {
		System.out.println(dto.getEmail());
		String orderAdded = inventoryService.orderAdd(dto);
		return ResponseEntity.status(HttpStatus.OK).body(CommonResponse.<String>builder().data(orderAdded)
				.message("ordersAdded Successfull").isError(false).build());
	}
	@GetMapping(path = "/orderlist/getall")
	  ResponseEntity<CommonResponse<List<PurchaseOrderDto>>> getAllOrders(){
		List<PurchaseOrderDto> orders=inventoryService.getALLorders();
		return ResponseEntity.status(HttpStatus.OK).body(CommonResponse.<List<PurchaseOrderDto>>builder()
				.isError(false).message("List Orders Fetched Sucessfully").data(orders).build());
	}
	@DeleteMapping(path = "/orderlist/delete")
	ResponseEntity<CommonResponse<String>> deleteOrders(@RequestBody PurchaseOrderDto dto){
		String orderDelete=inventoryService.deleteOrders(dto);
		return ResponseEntity.status(HttpStatus.OK).body(CommonResponse.<String>builder()
				.isError(false).data(orderDelete).message("USER_DELETED_SUCCESS").build());
	}
	
	@PutMapping(path = "/orderlist/put")
	public ResponseEntity<CommonResponse<PurchaseOrderDto>> updateOrder(@RequestBody PurchaseOrderDto dto) {
		PurchaseOrderDto updatedorder = inventoryService.updateOrder(dto);
		return ResponseEntity.status(HttpStatus.OK).body(CommonResponse.<PurchaseOrderDto>builder().data(updatedorder)
				.isError(false).message("USER_UPDATE_SUCCESS").build());
	}
	@PostMapping(path = "/inventory")
	ResponseEntity<CommonResponse<String>> inventoryAdd(@RequestBody InventoryItemsDto dto) {
		String inventoryAdded = inventoryService.inventoryAdd(dto);
		return ResponseEntity.status(HttpStatus.OK).body(CommonResponse.<String>builder().data(inventoryAdded)
				.message("InventoryAdded Successfull").isError(false).build());
	}
	
	@GetMapping(path = "/inventory/get")
	ResponseEntity<CommonResponse<InventoryItemsDto>> inventoryItemGet(@RequestParam(name="itemId") Integer itemId) {
		InventoryItemsDto inventoryItemfetch = inventoryService.inventoryItemGet(itemId);
		return ResponseEntity.status(HttpStatus.OK).body(CommonResponse.<InventoryItemsDto>builder().data(inventoryItemfetch)
				.message("fetchinig  Successfull").isError(false).build());
	}
	@PutMapping(path = "/inventory/put")
	public ResponseEntity<CommonResponse<InventoryItemsDto>> updateInventoryItems(@RequestBody InventoryItems dto) {
		InventoryItemsDto updatedItem = inventoryService.updateInventoryItems(dto);
		return ResponseEntity.status(HttpStatus.OK).body(CommonResponse.<InventoryItemsDto>builder().data(updatedItem)
				.isError(false).message("ITEM_UPDATE_SUCCESS").build());
	}
     @GetMapping(path = "/inventory/getall")
     ResponseEntity<CommonResponse<List<InventoryItemsDto>>> userGetAllProducts(){
 		List<InventoryItemsDto> allProductos=inventoryService.userGetAllProducts();
 		return ResponseEntity.status(HttpStatus.OK).body(CommonResponse.<List<InventoryItemsDto>>builder().data(allProductos)
 				 .isError(false).message("ALL_USERS_FETCHED_SUCCESSFULLY").build());
 	}
     @DeleteMapping(path = "/inventory/delete")
 	ResponseEntity<CommonResponse<String>> deleteItem(@RequestBody  InventoryItems dto){
 		String itemDelete=inventoryService.deleteItem(dto);
 		return ResponseEntity.status(HttpStatus.OK).body(CommonResponse.<String>builder()
 				.isError(false).data(itemDelete).message("ITEM_DELETED_SUCCESS").build());
 	}


	@PostMapping(path = "/purchaseItems")
	ResponseEntity<CommonResponse<Integer>> orderItemsAdd(@RequestBody PurchaseOrderItemsListDto dto) {
		Integer orderItemsAdded = inventoryService.orderItemsAdd(dto);
		return ResponseEntity.status(HttpStatus.OK).body(CommonResponse.<Integer>builder().data(orderItemsAdded)
				.message("ordersItemsAdded Successfull").isError(false).build());
	}
	
	@GetMapping(path = "/purchaseItems/getall")
	ResponseEntity<CommonResponse<List<PurchaseOrderItemsDto>>> getAllItems(){
		List<PurchaseOrderItemsDto> orderitems=inventoryService.getAllOrdersItems();
		return ResponseEntity.status(HttpStatus.OK).body(CommonResponse.<List<PurchaseOrderItemsDto>>builder().data(orderitems)
				 .isError(false).message("ALL_ORDERSITEMS_FETCHED_SUCCESSFULLY").build());
	}
	@PutMapping(path = "/purchaseItems/put")
	ResponseEntity<CommonResponse<PurchaseOrderItemsDto>> updatePurchaseorderItemDto(@RequestBody PurchaseOrderItemsDto dto){
		PurchaseOrderItemsDto updatedPurchaseItem=inventoryService. updatePurchaseorderItemDto(dto);
		return ResponseEntity.status(HttpStatus.OK).body(CommonResponse.<PurchaseOrderItemsDto>builder()
				.message("updated success").data(updatedPurchaseItem).isError(false).build());
	}
	@PostMapping(path = "/admin")
	ResponseEntity<CommonResponse<String>> adminAdd(@RequestBody AdminDto dto) {
		String adminAdded = inventoryService.adminAdd(dto);
		return ResponseEntity.status(HttpStatus.OK).body(CommonResponse.<String>builder().data(adminAdded)
				.message("Admin Added Successfull").isError(false).build());
	}
	
	@PostMapping(path = "/admin/login")
	ResponseEntity<CommonResponse<String>> adminLogin(@RequestBody  AdminDto dto) {
		String adminAdded = inventoryService.adminLogin(dto);
		return ResponseEntity.status(HttpStatus.OK).body(
				CommonResponse.<String>builder().data(adminAdded).message("Login Successfull").isError(false).build());
	}

}



