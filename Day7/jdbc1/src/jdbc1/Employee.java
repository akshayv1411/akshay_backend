package jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Employee {
	static Connection conn;
    static Scanner scanner = new Scanner(System.in);

    
    public static void connect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String user = "root";
        String password = "Sa123";
        conn = DriverManager.getConnection(url, user, password);
        
       
    }

    
    public static void insertEmployee() throws SQLException {
        System.out.println("Enter Employee ID:");
        int id = scanner.nextInt();
        System.out.println("Enter Employee Name:");
        String name = scanner.next();
        System.out.println("Enter Employee Salary:");
        double salary = scanner.nextDouble();
        System.out.println("Enter Employee Department:");
        String department = scanner.next();

        String sql = "INSERT INTO employees (ID, Name, Salary, Department) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, id);
        statement.setString(2, name);
        statement.setDouble(3, salary);
        statement.setString(4, department);

        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("A new employee was added!");
        }
    }

 
    public static void selectEmployeeById() throws SQLException {
        System.out.println("Enter Employee ID:");
        int id = scanner.nextInt();
        String sql = "SELECT * FROM employees WHERE ID = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();

        if (result.next()) {
            System.out.println("ID: " + result.getInt("ID"));
            System.out.println("Name: " + result.getString("Name"));
            System.out.println("Salary: " + result.getDouble("Salary"));
            System.out.println("Department: " + result.getString("Department"));
        } else {
            System.out.println("No employee found with ID: " + id);
        }
    }

    
    public static void selectAllEmployees() throws SQLException {
        String sql = "SELECT * FROM employees";
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);

        while (result.next()) {
            System.out.println("ID: " + result.getInt("ID"));
            System.out.println("Name: " + result.getString("Name"));
            System.out.println("Salary: " + result.getDouble("Salary"));
            System.out.println("Department: " + result.getString("Department"));
            System.out.println("----------------------");
        }
    }

    
    public static void updateEmployee() throws SQLException {
        System.out.println("Enter Employee ID:");
        int id = scanner.nextInt();
        System.out.println("Enter new Salary:");
        double salary = scanner.nextDouble();
        
        String sql = "UPDATE employees SET Salary = ? WHERE ID = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1, salary);
        statement.setInt(2, id);

        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Employee details updated !");
        } else {
            System.out.println("No employee found with ID: " + id);
        }
    }

  
    public static void deleteEmployee() throws SQLException {
        System.out.println("Enter Employee ID:");
        int id = scanner.nextInt();
        
        String sql = "DELETE FROM employees WHERE ID = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, id);

        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("Employee deleted successfully!");
        } else {
            System.out.println("No employee found with ID: " + id);
        }
    }

    public static void main(String[] args) {
        try {
      
            Class.forName("com.mysql.cj.jdbc.Driver");

            connect();

   
            int choice;
            do {
                System.out.println("press 1 to Insert Employee");
                System.out.println("press 2 to Select Employee by ID");
                System.out.println("press 3 to Select All Employees");
                System.out.println("press 4 to Update Employee Fields");
                System.out.println("press 5 to Delete Employee");
                System.out.println("6. Exit");
                System.out.println("Enter your choice:");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        insertEmployee();
                        break;
                    case 2:
                        selectEmployeeById();
                        break;
                    case 3:
                        selectAllEmployees();
                        break;
                    case 4:
                        updateEmployee();
                        break;
                    case 5:
                        deleteEmployee();
                        break;
                    case 6:
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
            } while (choice != 6);
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
