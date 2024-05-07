package java8_Sample_Coding_Questions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SecLarNumInArr {
	public static void main(String[] args) {
		List<Integer> listofIntgers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		Integer secondLargest = listofIntgers.stream()
				.sorted(Comparator.reverseOrder())
				.skip(1)
				.findFirst()
				.get();
		System.out.println("Second Largest number: " + secondLargest );
		
	}

}
