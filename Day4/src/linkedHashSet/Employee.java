package linkedHashSet;
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
    public int hashCode() {
    	return this.salary;
    }
    
    @Override
    public boolean equals(Object e) {
    	Employee employees = (Employee)e;
		return this.name == employees.name && this.salary == employees.salary;
    }
    
    
    @Override
    public String toString() {
        return this.eId+" "+this.name+" "+this.salary+" ";
    }

    public static void main(String[] args) {
    	
		Scanner scanner = new Scanner(System.in);
		Comparator<Employee> com = new Comparator<Employee>() {
			
			@Override
			public int compare(Employee o1, Employee o2) {
				return (o1.eId).compareTo(o2.eId);
			}
		};
        Set<Employee> employees = new LinkedHashSet<>();

        
        while(true) {
            System.out.println("Enter EID of Employee: ");
            int eId = scanner.nextInt();
            
            System.out.println("Enter Name of Employee: ");
            String name = scanner.next();
            
            System.out.println("Enter Salary of Employee: ");
            int salary = scanner.nextInt();
            
            System.out.println("Do you want to add some more employees ?");
            String data = scanner.next();

            employees.add(new Employee(eId, name, salary));
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
