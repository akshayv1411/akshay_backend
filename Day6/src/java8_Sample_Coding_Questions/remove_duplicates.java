package java8_Sample_Coding_Questions;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class remove_duplicates {
	public static void main(String[] args) {
        List<String> listOfStrings = Arrays.asList("aa","bb","cc","dd","aa","dd");

        List<String> uniqueList = listOfStrings.stream()
                                              .distinct()
                                              .collect(Collectors.toList());

        System.out.println("Original List: " + listOfStrings);
        System.out.println("List with Duplicates Removed: " + uniqueList);
    }
}
