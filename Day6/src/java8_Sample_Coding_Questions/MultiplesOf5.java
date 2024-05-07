package java8_Sample_Coding_Questions;

import java.util.List;

public class MultiplesOf5 {
    public static void printMultiplesOf5(List<Integer> listOfIntegers) {
        listOfIntegers.stream()
                      .filter(i -> i % 5 == 0)
                      .forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<Integer> listOfIntegers = List.of(10, 15, 20, 25, 30, 35);
        printMultiplesOf5(listOfIntegers);
    }
}

