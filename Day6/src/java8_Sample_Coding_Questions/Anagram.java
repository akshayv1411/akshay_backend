package java8_Sample_Coding_Questions;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Anagram {
	public static void main(String[] args) {
		String s1 = "flow";
		String s2 = "wolf";
		s1 = Stream.of(s1.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
		s2 = Stream.of(s2.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
		
		System.out.println("Given two strings are Anagram : " + s1.equals(s2));
	}
}