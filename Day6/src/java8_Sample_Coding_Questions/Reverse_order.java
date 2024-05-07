package java8_Sample_Coding_Questions;

import java.util.List;
import java.util.Comparator;

public class Reverse_order {
	  public static void main(String[] args) {
	        List<Integer> anyList = List.of(11,13,15,17,19);
	        anyList.stream()
	               .sorted(Comparator.reverseOrder())
	               .forEach(System.out::println);
	    }

}
