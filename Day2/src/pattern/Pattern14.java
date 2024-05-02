package pattern;

public class Pattern14 {

	public static void main(String[] args) {
		int num = 5;
		
		for(int i=1; i<=num+1; i++) {
			for(int j=i; j<=num; j++) {
				System.out.print(i);
			}
			
			System.out.println( );		
		}
		
//		
//		output
//		11111
//		2222
//		333
//		44
//		5
//

	}

}
