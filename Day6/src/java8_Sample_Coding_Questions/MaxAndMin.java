package java8_Sample_Coding_Questions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaxAndMin {
	public static void main(String[] args) {
		List<Integer> listOfIntegers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
		Integer max = listOfIntegers.stream().max(Comparator.naturalOrder()).get();
		System.out.println("The maximum value of list is: " + max);
		
		Integer min = listOfIntegers.stream().min(Comparator.naturalOrder()).get();
		System.out.println("The minimum value of list is: " + min);

	}

}
