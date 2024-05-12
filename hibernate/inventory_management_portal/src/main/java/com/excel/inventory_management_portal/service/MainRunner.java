package com.excel.inventory_management_portal.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.Date;

public class MainRunner {
    public static void main(String[] args) {
        // Create SessionFactory
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        // Create session
        Session session = sessionFactory.openSession();

        // Begin transaction
        Transaction transaction = session.beginTransaction();

        try {
            // Creating sample entities
            User user = new User();
            user.setUsername("admin");
            user.setEmail("admin@example.com");
            user.setPasswordHash("admin123");
            user.setIsAdmin(true);
            user.setCreatedAt(new Date());

            InventoryItem item1 = new InventoryItem();
            item1.setName("Item 1");
            item1.setDescription("Description for Item 1");
            item1.setCategory("Category A");
            item1.setUnitPrice(10.0);
            item1.setQuantityOnHand(100);
            item1.setReorderPoint(20);
            item1.setCreatedAt(new Date());

            PurchaseOrder purchaseOrder = new PurchaseOrder();
            purchaseOrder.setUser(user);
            purchaseOrder.setSupplier("Supplier X");
            purchaseOrder.setOrderDate(new Date());
            purchaseOrder.setStatus("Pending");
            purchaseOrder.setCreatedAt(new Date());

            SalesOrder salesOrder = new SalesOrder();
            salesOrder.setUser(user);
            salesOrder.setCustomer("Customer Y");
            salesOrder.setOrderDate(new Date());
            salesOrder.setStatus("Pending");
            salesOrder.setCreatedAt(new Date());

            // Persist entities
            session.save(user);
            session.save(item1);
            session.save(purchaseOrder);
            session.save(salesOrder);

            // Commit transaction
            transaction.commit();
            System.out.println("Entities saved successfully!");
        } catch (Exception e) {
            // Rollback transaction if an error occurs
            transaction.rollback();
            e.printStackTrace();
        } finally {
            // Close session and session factory
            session.close();
            sessionFactory.close();
        }
    }
}
