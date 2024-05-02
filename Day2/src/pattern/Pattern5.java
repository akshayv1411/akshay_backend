package pattern;

public class Pattern5 {

	public static void main(String[] args) {
		
		int num2 = 9;
		
		for(int i=1; i<=num2; i++) {
			int k = i;
			for(int j=1; j<=i; j++) {
				System.out.print(k++ + " ");
			}
			System.out.println( );		
		}
		//5
//		Output:		
//		1 
//		2 3 
//		3 4 5 
//		4 5 6 7 
//		5 6 7 8 9 
//		6 7 8 9 10 11 
//		7 8 9 10 11 12 13 
//		8 9 10 11 12 13 14 15 
//		9 10 11 12 13 14 15 16 17 


	}

}
