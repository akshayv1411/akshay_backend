package hashSet;
import java.util.*;

public class Student {

    private Integer sId;
    private String name;
    private Integer age;
    private Integer marks;

    public Student() {
        super();
    }
    
    public Student(Integer sId, String name, Integer age, Integer marks) {
        super();
        this.sId = sId;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }
    
    public Integer geteId() {
        return sId;
    }
    
    public void setSId(int sId) {
        this.sId = sId;
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
    
    public Integer getMarks() {
        return marks;
    }
    
    public void setMarks(int marks) {
        this.marks = marks;
    }
    
    @Override
    public int hashCode() {
    	return this.age;
    }
    
    @Override
    public boolean equals(Object e) {
    	Student students = (Student)e;
		return this.name == students.name && this.marks == students.marks;
    }
    
    
    @Override
    public String toString() {
        return this.sId+" "+this.name+" "+this.age+" "+this.marks+" ";
    }
    
    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        
        while(true) {
            System.out.println("Enter SID of Student: ");
            int sID = scanner.nextInt();
            System.out.println("Enter Name of Student: ");
            String name = scanner.next();
            System.out.println("Enter Age of Student: ");
            int age = scanner.nextInt();
            
            System.out.println("Enter Marks of Student: ");
            int marks = scanner.nextInt();
            
            System.out.println("Do you want to add some more students ?");
            String data = scanner.next();

            students.add(new Student(sID, name, age, marks));
            if(!data.equalsIgnoreCase("yes"))
                break;
        }
        
        Iterator<Student> itr = students.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }
        
        scanner.close();
    }

}
