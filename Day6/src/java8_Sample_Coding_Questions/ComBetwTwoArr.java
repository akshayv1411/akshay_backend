package java8_Sample_Coding_Questions;

import java.util.Arrays;
import java.util.List;

public class ComBetwTwoArr {	
	public static void main(String[] args) {
		List<Integer> listOfIntegers1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
		List<Integer> listOfIntegers2 = Arrays.asList(10, 11, 12, 13, 14, 15);
		System.out.println("Common elements between two arrays are : ");
		listOfIntegers1.stream().filter(listOfIntegers2::contains).forEach(System.out::println);
	}
}
