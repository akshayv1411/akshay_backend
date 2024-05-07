package streams;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8Problems {
	
	public static void main(String[] args) {
		
		//List<Integer> asList = Arrays.asList(1,2,34,5,5,8,3,167,45);
		
		//asList.stream().map(e -> e+"").filter(e -> e.startsWith("1")).forEach(System.out::println);
		
		//Set<Integer> set = new HashSet();
		//
		//asList.stream().filter(e -> set.add(e)).forEach(System.out::println);
		
		
		//Integer integer = asList.stream().max((o1,o2)) -> o1.compareTo(o2).get();
		//System.out.println(Integer);
		
		/*String input = "Java articles are awesome";
		Character character = input.chars().mapToObj(c -> (char)c)
				.filter(e -> input.indexOf(e) == input.lastIndexOf(e))
				.findFirst().get();
			System.out.println(character);*/
		
		//String input = "asddjklasdjklk";
		
		//Map<Character,Long> collect = input.chars().mapToObj(c -> (char)c)
			//	.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		
		
	}

}
