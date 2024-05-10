//package com.excel.hibernate.onetoone.service;
//
//import com.excel.hibernate.onetoone.entity.MarksCard;
//import com.excel.hibernate.onetoone.entity.Student;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.EntityTransaction;
//import jakarta.persistence.Persistence;
//
//public class MainRunner {
//	
//	private static EntityManagerFactory factory;
//	private static EntityManager manager;
//	private static EntityTransaction transaction;
//	
//	public static void main(String[] args) {
//		factory = Persistence.createEntityManagerFactory("student");
//		manager = factory.createEntityManager();
//		transaction = manager.getTransaction();
//		
//		MarksCard card = new MarksCard();
//		card.setMarks(100);
//		card.setGrade("A");
//		
//		
//		
//		Student st = new Student();
//		st.setName("Akshay");
//		st.setAge(23);
//		
//		transaction.begin();
//		manager.persist(st);
//		transaction.commit();
//		manager.close();
//	}
//
//}