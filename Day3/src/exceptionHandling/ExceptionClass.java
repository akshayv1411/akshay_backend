package exceptionHandling;

public class ExceptionClass {
	
	public  void exception() {
		try {
			int num = 10/0;
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
			
		}
		finally {
			System.out.println("Exception handled");
		}
	}
	
	public void arrayOutOfBound() {
		try {
			int[] arr = new int[3];
			arr[4] = 10;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			System.out.println("Array index out of range");
		}
	}
	
	public void nullPointer() {
		try {
			int num = (Integer) null;
			int num2 = num *2;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			System.out.println("Can't multiply null values");
		}
	}

	public static void main(String[] args) {
		ExceptionClass e = new ExceptionClass();
		System.out.println("From exception() : ");
		e.exception();
		System.out.println();
		System.out.println("From arrayOutOfBound() : ");
		e.arrayOutOfBound();
		System.out.println();
		System.out.println("From nullPointer() : ");
		e.nullPointer();
	}

}
