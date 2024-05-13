package com.excel.spring.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainRunner {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		
//		Student student = context.getBean("std", Student.class);
		Student student = context.getBean("student", Student.class);
		
//		student.study();
		
//		System.err.println(student);
		
		student.study();
	}
}