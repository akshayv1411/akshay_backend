package java8_Sample_Coding_Questions;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ThreeMaxAndMin {
	public static void main(String[] args) {
		
		List<Integer> listofIntgers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		listofIntgers.stream().sorted().limit(3).forEach(System.out::println);
		System.out.println("_____________________________________________________________________________");
		
		List<Integer> listofIntegers = Arrays.asList(10,9,8,7,6,5,4,3,2,1);
		listofIntgers.stream().sorted().
		forEach(System.out::println);
	}
	
}
