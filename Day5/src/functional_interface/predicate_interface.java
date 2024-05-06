package functional_interface;
import java.util.function.Predicate;

public class predicate_interface {
    public static void main(String[] args) {
        Predicate<Integer> isEven = num -> num % 2 == 0;

        System.out.println("Is 5 even? " + isEven.test(5)); 
        System.out.println("Is 10 even? " + isEven.test(10)); 
    }

}


