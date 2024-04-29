package demo;
import java.util.Scanner;

public class arrays {
		public static void main(String[] args) {
			
		Scanner scanner = new Scanner(System.in);
		System.out.print(" Enter the size of the array :  ");
		
		int size = scanner.nextInt();
		
		int []arr = new int[size];
		
		System.out.println("Enter the elements");
		for (int i =0; i < arr.length;i++) {
			arr[i] = scanner.nextInt();
		}
		
		for (int i=0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
	}
}	
