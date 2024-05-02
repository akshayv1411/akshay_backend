package pattern;

public class Pattern3 {
	public static void main(String[] args) {
		
		int num2 = 9;
		
		for(int i=1; i<=num2; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print(j);
			}
			System.out.println( );		
		}
		//3
//      Output:
//		1
//		12
//		123
//		1234
//		12345
//		123456
//		1234567
//		12345678
//		123456789
	}

}
