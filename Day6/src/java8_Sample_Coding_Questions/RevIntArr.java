package java8_Sample_Coding_Questions;


import java.util.stream.IntStream;

public class RevIntArr {
	public static void main(String[] args) {
		int[] listOfIntegers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
		int[] reversedArray = IntStream.rangeClosed(1, listOfIntegers.length)
			.map(e -> listOfIntegers[listOfIntegers.length-e]).toArray();
		
		System.out.print("Reversed Array: ");
		
		for(int i : reversedArray) {
			System.out.print(i + " ");
		}
	}

}
