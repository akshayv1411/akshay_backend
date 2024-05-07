package java8_Sample_Coding_Questions;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RevEacWordOfStr {
	public static void main(String[] args) {
		String str = "good evening";
		System.out.println(Arrays.stream(str.split(" ")).map(word -> new StringBuffer(word).reverse()).collect(Collectors.joining(" ")));
	}

}
