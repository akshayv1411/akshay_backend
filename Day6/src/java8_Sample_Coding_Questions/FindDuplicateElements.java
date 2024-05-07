package java8_Sample_Coding_Questions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindDuplicateElements {

	public static void main(String[] args) {
		List<Integer> asList = Arrays.asList(1, 2, 3, 6, 5, 6, 7, 7, 9, 9, 11, 12, 13, 14, 15);
		
		Set<Integer> set = new HashSet<>();
//		asList.stream().filter(e -> !set.add(e)).forEach(System.out::println); //NotFalse, "true" become "false" and "false" become "true",
		System.out.println("Duplicate elements in given array are : " + asList.stream().filter(e -> !set.add(e)).collect(Collectors.toSet()));
	}
}