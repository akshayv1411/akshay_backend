package java8_Sample_Coding_Questions;
import java.util.Arrays;
import java.util.stream.IntStream;

public class MergeUnsortedArrayWithoutDup {
	public static void main(String[] args) {
		int[] listOfIntegers1 = {8, 9, 12, 13, 14, 10, 1};
		int[] listOfIntegers2 = { 12, 13, 4, 15, 6, 7, 11, 15};
		
		int[] res = IntStream.concat(Arrays.stream(listOfIntegers1), Arrays.stream(listOfIntegers2))
				.sorted().distinct().toArray();
		int[] sorted = {};
		
		for (int i : res) {
			System.out.print(i + " ");
		}
	}

}
