package Day5; 

import java.util.*;

public class Employee {
    private int id;
    private String name;
    private String designation;
    private String department;
    
    
    public Employee(int id, String name, String designation, String department) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.department = department;
    }
    
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getDesignation() {
        return designation;
    }
    
    public String getDepartment() {
        return department;
    }
    
    @Override
    public String toString() {
        return "{" +
                ", name='" + name + '\'' +
                ", designation='" + designation + '\'' +
                ", department='" + department + '\'' +
                '}';
    }


    public static void main(String[] args) {    
        HashMap<Integer, Employee> employees = new HashMap<>();
        employees.put(120, new Employee(101, "Akshay", "Manager", "HR"));
        employees.put(119, new Employee(103, "Sachin", "Engineer", "IT"));
        employees.put(118, new Employee(102, "Oliver", "Analyst", "Finance"));
        
        TreeMap<Integer, Employee> sortedEmployees = new TreeMap<>(employees);
        
        for (Map.Entry<Integer, Employee> entry : sortedEmployees.entrySet()) {
            System.out.println("ID: " + entry.getKey() + ", Employee: " + entry.getValue());
        }
    }
}
