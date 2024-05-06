package functional_interface;
import java.util.function.Supplier;

public class SupplierInterface {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> "Hello, World!";
        String value = supplier.get();
        System.out.println(value);
    }
	
}








