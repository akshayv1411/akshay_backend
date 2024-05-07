package java8_Sample_Coding_Questions;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Palindrome {

	public static void main(String[] args) {
		String s = "LIRIL";
		System.out.print("Given string '" + s + "' is Palindrome: ");
		System.out.println(IntStream.range(0, s.length()/2).noneMatch(e -> s.charAt(e) != s.charAt(s.length()- e-1)));
	}

}
