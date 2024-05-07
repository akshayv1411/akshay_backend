package java8_Sample_Coding_Questions;
import java.util.stream.IntStream;

public class SumOfFirstTen {
	public static void main(String[] args) {
		System.out.println("Sum of first 10 Natural Numbers: " + IntStream.range(1, 11).sum());
	}

}
