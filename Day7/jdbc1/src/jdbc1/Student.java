package jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Student {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Scanner scanner = new Scanner(System.in);
			
			String url = "jdbc:mysql://localhost:3306/jdbc";
			String user = "root";
			String pass = "Sa123";
			
			Connection connection = DriverManager.getConnection(url, user, pass);
			
			String query = "insert into student(name, percentage, address) values (?,?,?)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			System.out.println("Please enter the name: ");
			preparedStatement.setString(1, scanner.nextLine());
			
			System.out.println("Please enter the percentage: ");
			preparedStatement.setDouble(2, Double.parseDouble(scanner.nextLine()));
			
			System.out.println("Please enter the address: ");
			preparedStatement.setString(3, scanner.nextLine());
			
			boolean execute = preparedStatement.execute();

			
			if(execute == false) {
				System.out.println("Record inserted succssefully!");
			}
			
			connection.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
