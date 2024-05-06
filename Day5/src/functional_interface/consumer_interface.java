package functional_interface;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class consumer_interface {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Consumer<Integer> consumer = (Integer num) -> {
            System.out.println(num * num);
        };
        numbers.forEach(consumer);
    }
}
