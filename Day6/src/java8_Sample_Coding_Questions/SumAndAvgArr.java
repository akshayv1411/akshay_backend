package java8_Sample_Coding_Questions;

import java.util.Arrays;
import java.util.List;


public class SumAndAvgArr {
	public static void main(String[] args) {
		int[] listOfIntegers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
		System.out.println("Sum of all elements: " + Arrays.stream(listOfIntegers).sum());
		System.out.println("Average of of elements: " + Arrays.stream(listOfIntegers).average().getAsDouble());
	}


}
