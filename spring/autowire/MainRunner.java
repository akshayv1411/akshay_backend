package com.excel.spring.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainRunner {

	public static void main(String[] args) 
	{
		 ApplicationContext context=new ClassPathXmlApplicationContext("com/excel/spring/autowire/config.xml");
		 
		 Employee employee= (Employee)context.getBean("employee",Employee.class);
		 System.err.println(employee);
	}

}