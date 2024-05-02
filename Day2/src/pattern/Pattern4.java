package pattern;

public class Pattern4 {

	public static void main(String[] args) {
		int num2 = 9;
		for(int i=1; i<=num2+1; i++) {
			for(int j=i; j<=num2; j++) {
				System.out.print(j);
			}
			System.out.println( );		
		}
		//4
//		Output:
//		123456789
//		23456789
//		3456789
//		456789
//		56789
//		6789
//		789
//		89
//		9

	}

}
