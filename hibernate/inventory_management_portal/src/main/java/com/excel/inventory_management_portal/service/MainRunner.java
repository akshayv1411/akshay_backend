package com.excel.inventory_management_portal.service;


import java.util.Date;
import java.time.LocalDate;
import java.util.Date;

import com.excel.inventory_management_portal.entity.InventoryItem;
import com.excel.inventory_management_portal.entity.PurchaseOrder;
import com.excel.inventory_management_portal.entity.SalesOrder;
import com.excel.inventory_management_portal.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;


public class MainRunner {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("inventory_management_portal");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

            User user = new User();
            user.setUsername("admin");
            user.setEmail("admin@example.com");
            user.setPasswordHash("admin123");
            user.setIsAdmin(true);
            user.setCreatedAt(null);

            InventoryItem item1 = new InventoryItem();
            item1.setName("Item 1");
            item1.setDescription("Description for Item 1");
            item1.setCategory("Category A");
            item1.setUnitPrice(10.0);
            item1.setQuantityOnHand(100);
            item1.setReorderPoint(20);
            item1.setCreatedAt(null);

            PurchaseOrder purchaseOrder = new PurchaseOrder();
            purchaseOrder.setUser(user);
            purchaseOrder.setSupplier("Supplier X");
            purchaseOrder.setOrderDate(LocalDate.now());
            purchaseOrder.setStatus("Pending");
            purchaseOrder.setCreatedAt(null);

            SalesOrder salesOrder = new SalesOrder();
            salesOrder.setUser(user);
            salesOrder.setCustomer("Customer Y");
            salesOrder.setOrderDate(LocalDate.now());
            salesOrder.setStatus("Pending");
            salesOrder.setCreatedAt(null);
            
            transaction.begin();
            
            
            manager.persist(user);
            manager.persist(item1);
            manager.persist(purchaseOrder);
            manager.persist(salesOrder);
            
            
            transaction.commit();
            manager.close();

    }
}
