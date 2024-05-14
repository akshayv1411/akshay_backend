package com.excel.springjdbc;

import com.excel.springjdbc.dao.StudentDao;
import com.excel.springjdbc.entities.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
        StudentDao studentDao = context.getBean(StudentDao.class);
        Scanner scanner = new Scanner(System.in);

       
       
        System.out.println("Press 1 to add a new student");
        System.out.println("Press 2 to display all students");
        System.out.println("Press 3 to get details of a student");
        System.out.println("Press 4 to delete a student");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                System.out.println("Invalid choice");
        }

        context.close();
        scanner.close();
    }
}
