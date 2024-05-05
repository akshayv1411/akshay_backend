package collections;

import java.util.*;

public class Employee {
    
    private Integer eId;
    private String name;
    private Integer salary;

    public Employee() {
        super();
    }
    
    public Employee(Integer eid, String name, Integer salary) {
        super();
        this.eId = eid;
        this.name = name;
        this.salary = salary;
    }
    
    public Integer geteId() {
        return eId;
    }
    
    public void setEId(int eId) {
        this.eId = eId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Integer getSalary() {
        return salary;
    }
    
    public void setSalary(int salary) {
        this.salary = salary;
    }
    
    @Override
    public String toString() {
        return "[eId=" + eId + ", name=" + name + ", salary=" + salary + "]";
    }
    
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        while(true) {
            System.out.println("Enter EID of employee: ");
            int eID = scanner.nextInt();
            System.out.println("Enter Name of employee: ");
            String name = scanner.next();
            System.out.println("Enter Salary of employee: ");
            int salary = scanner.nextInt();
            
            System.out.println("Do you want to add some more employees ?");
            String data = scanner.next();

            employees.add(new Employee(eID, name, salary));
            if(!data.equalsIgnoreCase("yes"))
                break;
        }
        
        Iterator<Employee> itr = employees.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }
        
        scanner.close();
    }
}
