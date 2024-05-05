package treeSet;
import java.util.*;

public class Register {
	
    private Integer id;
    private String name;
    private Integer age;
    private String phone;
    
    public Register() {
		super();
	}
    
    public Register(Integer id, String name, Integer age, String phone) {
    	super();
    	this.id = id;
    	this.name = name;
    	this.age = age;
    	this.phone= phone;
    }
    
    public Integer getId() {
    	return id;
    }
    
    public void setId(int id) {
    	this.id = id;
    }
    
    public String getName() {
    	return name;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public Integer getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
    @Override
    public String toString() {
        return this.id+" "+this.name+" "+this.age+" "+this.phone+" ";
    }
    

	public static void main(String[] args) {
		

		Scanner scanner = new Scanner(System.in);
		Comparator<Register> com = new Comparator<Register>() {
			
			@Override
			public int compare(Register o1, Register o2) {
				return (o1.id).compareTo(o2.id);
			}
		};
		
		TreeSet<Register> register = new TreeSet<Register>(com);
		
        while(true) {
            System.out.println("Enter id to Register: ");
            int id = scanner.nextInt();
            
            System.out.println("Enter Name to Register: ");
            String name = scanner.next();
            
            System.out.println("Enter Age to Register: ");
            int age = scanner.nextInt();
            
            System.out.println("Enter Phone number to Register: ");
            String phone = scanner.next();
            
            System.out.println("Do you want to add some more ?");
            String data = scanner.next();

            register.add(new Register(id, name, age, phone));
            if(!data.equalsIgnoreCase("yes"))
                break;
        }
        
        Iterator<Register> itr = register.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }
        
        scanner.close();

	}

}
