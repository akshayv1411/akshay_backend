package com.excel.hibernate.manytomany.service;

import java.util.ArrayList;
import java.util.List;

import com.excel.hibernate.manytomany.entity.Book;
import com.excel.hibernate.manytomany.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class MainRunner {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("student");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		

		List<Book> books = new ArrayList<Book>();
		List<Student> students = new ArrayList<Student>();
		Book book1 = new Book();
		Book book2 = new Book();
		Book book3 = new Book();
		
		book1.setTitle("Rich Dad Poor Dad");
		book2.setTitle("Psychology of money");
		book3.setTitle("Ikigai");
		
		books.add(book1);
		books.add(book2);
		books.add(book3);
		
		Student student1 = new Student();
		Student student2 = new Student();
		Student student3 = new Student();
		
		student1.setName("John");
		student1.setBooks(books)
;
		
		student2.setName("Oliver");
		student2.setBooks(books)
;
		
		student3.setName("Rohan");
		student3.setBooks(books)
;
		
		students.add(student1);
		students.add(student2);
		students.add(student3);
		
		book1.setStudents(students);
		book2.setStudents(students);
		book3.setStudents(students);
		
		transaction.begin();
		manager.persist(student1);
		transaction.commit();
	}
}