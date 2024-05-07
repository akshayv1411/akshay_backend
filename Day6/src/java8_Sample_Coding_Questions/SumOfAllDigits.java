package java8_Sample_Coding_Questions;

import java.util.stream.Collectors;
import java.util.stream.Stream;


public class SumOfAllDigits {
	
    public static int sumOfDigits(int inputNumber) {
        return Stream.of(String.valueOf(inputNumber).split(""))
                .mapToInt(Integer::parseInt)
                .sum();
    }

    public static void main(String[] args) {
        int inputNumber = 12345;
        int sum = sumOfDigits(inputNumber);
        System.out.println("Sum of digits: " + sum);
    }

}
