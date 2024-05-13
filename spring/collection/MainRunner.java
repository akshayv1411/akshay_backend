package com.excel.spring.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainRunner {

	public static void main(String[] args) 
	{
		ApplicationContext context= new ClassPathXmlApplicationContext("com.excel.spring.collection.config.xml");
		
		Employee employee= (Employee)context.getBean("employee");
		
		System.err.println(employee.getName());
		System.err.println(employee.getPhone());
		System.err.println(employee.getSkills());
		System.err.println(employee.getNominees());


	}

}