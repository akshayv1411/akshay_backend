package java8_Sample_Coding_Questions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StrInIncrOrder {
	public static void main(String[] args) {
		List<String> listOfStrings = Arrays.asList("Alice","Oliver", "Bob", "Stella");
		listOfStrings.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);
	}
}
