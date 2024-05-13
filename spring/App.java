package com.excel.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */



public class App 
{
    public static void main(String[] args)
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("com/excel/spring/config.xml");
    	
    	Student student1 = (Student)context.getBean("student");
    	
    	System.out.println(student1);
    	
    	
    }
}
