package pattern;

public class Pattern13 {

	public static void main(String[] args) {
		int num = 5;
		
		for(int i=1; i<=num+1; i++) {
			int num2 = 5;
			for(int j=i; j<=num; j++) {
				System.out.print(num2--);
			}
			
			System.out.println( );		
		}
	}
	
//	Output
//	54321
//	5432
//	543
//	54
//	5

}
