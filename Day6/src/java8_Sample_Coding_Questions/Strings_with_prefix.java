package java8_Sample_Coding_Questions;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Strings_with_prefix {
	public static void main(String[] args) {
		List<String> listOfStrings = Arrays.asList("Alice", "Bob", "Johnson");
		String collect = listOfStrings.stream().map(e -> "Mr. " + e + " Hi").collect(Collectors.joining(", ", "", ""));
		System.out.println(collect);
	}
}
