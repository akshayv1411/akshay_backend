package treeMap;
import java.util.*;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;


public class Employee {
    private String name;
    private String designation;
    private String department;
    
    public Employee() {
        super();
    }
    
    public Employee(String name, String designation, String department) {
        super();
        this.name = name;
        this.designation = designation;
        this.department = department;
    }
    
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDesignation() {
        return designation;
    }
    
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public String getDepartment() {
        return department;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }
    
    public String toString() {
        return this.name+" "+this.designation+" "+this.department+" ";
    }
    
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
//		Comparator<Integer> com = new Comparator<Integer>() {
//			
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				return (o1).compareTo(o2);
//			}
//		};
		
		
		Comparator<String> com = new Comparator<String>() {
			
			@Override
			public int compare(String o1, String o2) {
				return (o1).compareTo(o2);
			}
		};
		
//		TreeMap<Integer, Employee> employees = new TreeMap<>(com);
		TreeMap<String, Employee> employees = new TreeMap<>(com);
		
        while(true) {
            
            System.out.println("Enter Id of Employee: ");
            Integer id = scanner.nextInt();
        	
            System.out.println("Enter Name of Employee: ");
            String name = scanner.next();
            
            System.out.println("Enter designation of Employee: ");
            String designation = scanner.next();
            
            System.out.println("Enter department of Employee: ");
            String department = scanner.next();
            
            System.out.println("Do you want to add some more employees ?");
            String data = scanner.next();
            
//            employees.put(id, new Employee(name, designation, department));
            employees.put(name, new Employee(name, designation, department));

            if(!data.equalsIgnoreCase("yes"))
                break;
        }
        
//        Set<Entry<Integer, Employee>> entrySet = employees.entrySet();
        Set<Entry<String, Employee>> entrySet = employees.entrySet();  
        
        for(Entry<String, Employee> entry: entrySet) {
        	System.out.println(entry.getKey()+ "  -------->  " + entry.getValue());
        }
          scanner.close();
	}
}