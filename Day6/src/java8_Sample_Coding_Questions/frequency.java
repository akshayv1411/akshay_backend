package java8_Sample_Coding_Questions;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class frequency {
	public static Map<Character, Long> getCharacterFrequency(String inputString) {
        return inputString.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public static void main(String[] args) {
        String inputString = "Java articles are awesome";
        Map<Character, Long> frequencyMap = getCharacterFrequency(inputString);
        frequencyMap.forEach((character, frequency) -> System.out.println(character + ": " + frequency));
    }

}
