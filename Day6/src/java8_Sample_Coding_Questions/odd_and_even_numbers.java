package java8_Sample_Coding_Questions;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class odd_and_even_numbers {
	public static void main(String[] args ) {
		List<Integer> listOfIntegers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10,11,12,13,14,15,16,17,18,19,20);
		Map<Boolean, List<Integer>> oddEvenMap = listOfIntegers.stream()
                .collect(Collectors.partitioningBy(i -> i % 2 == 0));

        List<Integer> evenNumbers = oddEvenMap.get(true);
        List<Integer> oddNumbers = oddEvenMap.get(false);

        System.out.println("Even numbers: " + evenNumbers);
        System.out.println("Odd numbers: " + oddNumbers);
	}
}
