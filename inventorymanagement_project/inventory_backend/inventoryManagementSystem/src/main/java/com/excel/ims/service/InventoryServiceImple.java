package com.excel.ims.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excel.ims.dto.AdminDto;
import com.excel.ims.dto.InventoryItemsDto;
import com.excel.ims.dto.PurchaseOrderDto;
import com.excel.ims.dto.PurchaseOrderItemsDto;
import com.excel.ims.dto.PurchaseOrderItemsListDto;
import com.excel.ims.dto.PurchaseOrderListDto;
import com.excel.ims.dto.UserDto;
import com.excel.ims.entity.Admin;
import com.excel.ims.entity.InventoryItems;
import com.excel.ims.entity.PurchaseOrderItems;
import com.excel.ims.entity.PurchaseOrders;
import com.excel.ims.entity.User;
import com.excel.ims.exception.NoUserFoundException;
import com.excel.ims.repository.AdminRepository;
import com.excel.ims.repository.InventoryRepository;
import com.excel.ims.repository.PurchaseOrderItemsRepository;
import com.excel.ims.repository.PurchaseOrderRepository;
import com.excel.ims.repository.UserRepository;
import com.excel.ims.utils.ObjectUtils;
import static com.excel.ims.constant.InventoryConstants.USER_ALREDY_FOUND;
import static com.excel.ims.constant.InventoryConstants.INVALID_USER_NAME_AND_PASSWORD;
import static com.excel.ims.constant.InventoryConstants.NO_USER_FOUND;
import static com.excel.ims.constant.InventoryConstants.NO_EMAIL_FOUND;
import static com.excel.ims.constant.InventoryConstants.NO_ORDERS_FOUND;
import static com.excel.ims.constant.InventoryConstants.ITEM_ALREDAY_FOUND;
import static com.excel.ims.constant.InventoryConstants.ITEM_NOT_FOUND;
import static com.excel.ims.constant.InventoryConstants.DATA_NOT_FOUND;
import static com.excel.ims.constant.InventoryConstants.ITEM_NAME_NOT_FOUND;
import static com.excel.ims.constant.InventoryConstants.NO_USERS_FOUND;
import static com.excel.ims.constant.InventoryConstants.NO_ITEMS_FOUND;

@Service
public class InventoryServiceImple implements InventoryService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private InventoryRepository inventoryRepository;
	@Autowired
	private PurchaseOrderRepository purchaseOrderRepository;
	@Autowired
	private PurchaseOrderItemsRepository purchaseOrderItemRepository;
	@Autowired
	private AdminRepository adminRepository;

	@Override
	public String addUserInfo(UserDto dto) {
		try {
			if (!userRepository.findByEmail(dto.getEmail()).isPresent()) {
				User user = ObjectUtils.userDtoToEntitiy(dto);
				user.setAdmin(false);
				userRepository.save(user);
				return user.getEmail();
			}
		} catch (Exception e) {

			throw new NoUserFoundException(USER_ALREDY_FOUND);
		}
		throw new NoUserFoundException(USER_ALREDY_FOUND);
	}

	@Override
	public String userLogin(UserDto dto) {
		Optional<User> optional = userRepository.findByEmail(dto.getEmail());
		if (optional.isPresent()) {
			User user = optional.get();
			if (user.getPassword().equals(dto.getPassword())) {
				return user.getUsername();
			} else {
				return "Incorrect password";
			}
		}
		throw new NoUserFoundException(INVALID_USER_NAME_AND_PASSWORD);
	}

	@Override
	public UserDto userGet(String email) {
		Optional<User> optional = userRepository.findByEmail(email);
		if (optional.isPresent()) {
			User user = optional.get();
			UserDto user1 = ObjectUtils.userEntityToDto(user);
			return user1;
		}
		throw new NoUserFoundException(NO_USER_FOUND);
	}

	@Override
	public List<UserDto> userGetAll() {

		try {
			return userRepository.findAll().stream()
					.map(u -> UserDto.builder().email(u.getEmail()).createdAt(u.getCreatedAt())
							.password(u.getPassword()).userId(u.getUserId()).username(u.getUsername()).build())
					.toList();
		} catch (Exception e) {

			throw new NoUserFoundException(NO_USERS_FOUND);
		}
	}

	@Override
	public UserDto updateUser(UserDto dto) {
		Optional<User> optional = userRepository.findByEmail(dto.getEmail());
		if (optional.isPresent()) {
			User user = optional.get();
			user = ObjectUtils.updateValues(user, dto);
			User save = userRepository.save(user);
			return ObjectUtils.userEntityToDto(save);
		}
		throw new NoUserFoundException(NO_EMAIL_FOUND);
	}

	@Override
	public String deleteUser(UserDto dto) {
		Optional<User> optional = userRepository.findByEmail(dto.getEmail());
		if (optional.isPresent()) {
			User get = optional.get();
			userRepository.delete(get);
			return "User Deleted Successfully";

		}
		throw new NoUserFoundException(NO_USER_FOUND);
	}

	@Override
	public String orderAdd(PurchaseOrderListDto dto) {
		Optional<User> optional = userRepository.findByEmail(dto.getEmail());
		System.out.println("optional object is " + optional + "status" + optional.isPresent());
		try {
			if (optional.isPresent()) {
				User user = optional.get();
				System.out.println("user details :" + user);

				List<PurchaseOrders> purchaseOrders = ObjectUtils.ordersDtoToEntity(dto.getOrders());
				user.setPurchaseOrders(purchaseOrders);
				purchaseOrders.stream().forEach(x -> x.setUserTable(user));
				return userRepository.save(user).getEmail();
			}
		} catch (Exception e) {

			throw new NoUserFoundException("DUPLICATE_SUPPILER_NAME");
		}
		throw new NoUserFoundException(NO_ORDERS_FOUND);
	}

	@Override
	public String inventoryAdd(InventoryItemsDto dto) {
		try {
			if (!inventoryRepository.findByItemId(dto.getItemId()).isPresent()) {
				InventoryItems items = ObjectUtils.itemsDtoToEntity(dto);
				inventoryRepository.save(items);
				return items.getItemName();
			}
		} catch (Exception e) {

			throw new NoUserFoundException(ITEM_ALREDAY_FOUND);
		}

		throw new NoUserFoundException(ITEM_ALREDAY_FOUND);
	}

	@Override
	public Integer orderItemsAdd(PurchaseOrderItemsListDto dto) {
		Optional<InventoryItems> inventoryOptional = inventoryRepository.findByItemId(dto.getItemId());
		Optional<PurchaseOrders> orderOptional = purchaseOrderRepository.findByOrderId(dto.getOrderId());
		if (inventoryOptional.isPresent() && orderOptional.isPresent()) {
			InventoryItems items = inventoryOptional.get();
			PurchaseOrders orders = orderOptional.get();
			List<PurchaseOrderItems> purchaseOrderItems = ObjectUtils.orderItemsDtoToEntity(dto.getOrderItems());
			items.setPurchaseOrdersItems(purchaseOrderItems);
			orders.setPurchaseOrdersItems(purchaseOrderItems);
			purchaseOrderItems.stream().forEach(x -> x.setInventoryItem(items));
			purchaseOrderItems.stream().forEach(x -> x.setPurchaseOrder(orders));
			purchaseOrderRepository.save(orders);
			return inventoryRepository.save(items).getItemId();
		}
		throw new NoUserFoundException(ITEM_NOT_FOUND);
	}

	@Override
	public InventoryItemsDto inventoryItemGet(Integer itemId) {
		Optional<InventoryItems> optional = inventoryRepository.findByItemId(itemId);
		if (optional.isPresent()) {
			InventoryItems items = optional.get();
			InventoryItemsDto dtos = ObjectUtils.itemsEntityToDto(items);
			return dtos;
		}
		throw new NoUserFoundException(DATA_NOT_FOUND);
	}

	@Override
	public InventoryItemsDto updateInventoryItems(InventoryItems dto) {
		Optional<InventoryItems> optional = inventoryRepository.findByItemId(dto.getItemId());
		if (optional.isPresent()) {
			InventoryItems item = optional.get();
			item = ObjectUtils.updateValues(item, dto);
			InventoryItems save = inventoryRepository.save(item);
			return ObjectUtils.itemsEntityToDto(save);
		}
		throw new NoUserFoundException(ITEM_NAME_NOT_FOUND);
	}

	@Override
	public List<InventoryItemsDto> userGetAllProducts() {
		try {
			return inventoryRepository.findAll().stream()
					.map(i -> InventoryItemsDto.builder().itemId(i.getItemId()).itemName(i.getItemName())
							.description(i.getDescription()).category(i.getCategory()).unitPrice(i.getUnitPrice())
							.quantityOnHand(i.getQuantityOnHand()).reorderPoint(i.getReorderPoint())
							.createdAt(i.getCreatedAt()).build())
					.toList();
		} catch (Exception e) {

			throw new NoUserFoundException(NO_ITEMS_FOUND);
		}
	}

	@Override
	public String deleteItem(InventoryItems dto) {
		Optional<InventoryItems> optional = inventoryRepository.findByItemId(dto.getItemId());
		if (optional.isPresent()) {
			InventoryItems get = optional.get();
			inventoryRepository.delete(get);
			return "User Deleted Successfully";

		}
		throw new NoUserFoundException("NO_ITEM_FOUND");
	}

	@Override
	public List<PurchaseOrderDto> getALLorders() {
		try {
			return purchaseOrderRepository.findAll().stream()
					.map(o -> PurchaseOrderDto.builder().orderId(o.getOrderId()).status(o.getStatus())
							.supplier(o.getSupplier()).orderDate(o.getOrderDate()).createdAt(o.getCreatedAt())
							.email(o.getUserTable().getEmail()).build())
					.toList();
		} catch (Exception e) {
			throw new NoUserFoundException("NO_ORDERS_FOUND");
		}
	}

	@Override
	public String deleteOrders(PurchaseOrderDto dto) {
		Optional<PurchaseOrders> optional = purchaseOrderRepository.findByOrderId(dto.getOrderId());
		if (optional.isPresent()) {
			PurchaseOrders order = optional.get();
			purchaseOrderRepository.delete(order);
		}
		throw new NoUserFoundException("NO_ORDERS_FOUND");
	}

	@Override
	public List<PurchaseOrderItemsDto> getAllOrdersItems() {

		return purchaseOrderItemRepository.findAll().stream()
				.map(i -> PurchaseOrderItemsDto.builder().orderItemId(i.getOrderItemId()).quantity(i.getQuantity())
						.unitPrice(i.getUnitPrice()).orderId(i.getPurchaseOrder().getOrderId())
						.itemName(i.getInventoryItem().getItemName()).build())
				.toList();
	}

	@Override
	public PurchaseOrderDto updateOrder(PurchaseOrderDto dto) {
		Optional<PurchaseOrders> optional = purchaseOrderRepository.findByOrderId(dto.getOrderId());
		if (optional.isPresent()) {
			PurchaseOrders order = optional.get();
			order = ObjectUtils.updateValues(order, dto);
			PurchaseOrders save = purchaseOrderRepository.save(order);
			return ObjectUtils.orderEntityToDto(save);
		}
		throw new NoUserFoundException("NO_ORDERS_FOUND");
	}

	@Override
	public String adminAdd(AdminDto dto) {
		Optional<Admin> optional = adminRepository.findByEmail(dto.getEmail());
		if (!optional.isPresent()) {
			Admin admin = ObjectUtils.itemsDtoToEntity(dto);
			admin.setAdmin(true);
			adminRepository.save(admin);

			return admin.getEmail();
		}
		throw new NoUserFoundException("admin_ALready_FOUND");
	}

	@Override
	public String adminLogin(AdminDto dto) {
		Optional<Admin> optional = adminRepository.findByEmail(dto.getEmail());
		if(optional.isPresent()) {
			Admin admin = optional.get();
			if (admin.getPassword().equals(dto.getPassword())) {
				return "email and password matches!!";

			} else {
				return "Incorrect password";
			}
		}
		throw new NoUserFoundException(INVALID_USER_NAME_AND_PASSWORD);
	}

	@Override
	public PurchaseOrderItemsDto updatePurchaseorderItemDto(PurchaseOrderItemsDto dto) {
		Optional<PurchaseOrderItems> optional = purchaseOrderItemRepository.findByOrderItemId(dto.getOrderItemId());
		if(optional.isPresent()) {
			PurchaseOrderItems orderItems = optional.get();
			orderItems = ObjectUtils.updateValues(orderItems, dto);
			PurchaseOrderItems save = purchaseOrderItemRepository.save(orderItems);
			return ObjectUtils.orderItemsEntityToDto(save);
		}
		throw new NoUserFoundException("NO_ORDERITEM_ID_FOUND");
	}

}