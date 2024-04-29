package demo;

import java.util.Scanner;

public class ArrayOperations {
    public static void main(String[] args) {
        String[] names = {"Akshay", "Sachin", "Dhanush", "Manikanta"};

        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }

        
        ArrayOperations operations = new ArrayOperations();
        operations.printarray();
        operations.reversearray();
        
    }

    public void printarray() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array:");
        int size = scanner.nextInt();
        int[] arr = new int[size];

        System.out.println("Enter the elements");
        for(int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("elements:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    
    public void reversearray() {
            reverseArray();
        }

        public static void reverseArray() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the size of the array:");
            int size = scanner.nextInt();
            int[] num = new int[size];

            System.out.println("Enter numbers:");
            for (int i = 0; i < num.length; i++) {
                num[i] = scanner.nextInt();
            }

            System.out.println("Original array elements:");
            for (int i = 0; i < num.length; i++) {
                System.out.print(num[i] + " ");
            }
            System.out.println();

            int[] reverse = new int[size];
            for (int i = 0; i < size; i++) {
                reverse[i] = num[size - i - 1];
            }

            System.out.println("Reversed array :");
            for (int i = 0; i < size; i++) {
                System.out.print(reverse[i] + " ");
            }
        }
    
        
       public void Max_element() {
    	   
       }
}
