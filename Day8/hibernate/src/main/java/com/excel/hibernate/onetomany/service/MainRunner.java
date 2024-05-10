//package com.excel.hibernate.onetomany.service;
//
//
//import java.util.ArrayList;
//import java.util.List;
//
//import com.excel.hibernate.onetomany.entity.Laptop;
//import com.excel.hibernate.onetomany.entity.Student;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.EntityTransaction;
//import jakarta.persistence.Persistence;
//
//public class MainRunner {
//	
//	public static void main(String[] args) {
//		
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("student");
//		EntityManager manager = factory.createEntityManager();
//		EntityTransaction transaction= manager.getTransaction();
//		
//		List<Laptop> laptops = new ArrayList<>();
//		Laptop laptop1 = new Laptop();
//		Laptop laptop2 = new Laptop();
//		Laptop laptop3 = new Laptop();
//		Student students = new Student();
//		
//		laptop1.setBrand("Dell");
//		laptop1.setSerialNo("ABCD1234");
//		laptop1.setStudent(students);
//		
//		laptop2.setBrand("Dell");
//		laptop2.setSerialNo("ABCD567");
//		laptop2.setStudent(students);
//		
//		laptop3.setBrand("Dell");
//		laptop3.setSerialNo("ABCD789");
//		laptop3.setStudent(students);
//		
//		laptops.add(laptop1);
//		laptops.add(laptop2);
//		laptops.add(laptop3);
//		
//		students.setName("John");
//		students.setAge(23);
//		students.setLaptops(laptops);
//		
//		transaction.begin();
//		manager.persist(students);
//		transaction.commit();
//		System.out.println(manager.find(Student.class, 1));
//	}
//}
