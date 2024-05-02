package pattern;

public class Pattern2 {

	public static void main(String[] args) {
		
		int num = 5;
		
		for(int i=1; i<num+1; i++) {
			for(int j=1; j<num+1; j++) {
				System.out.print(i);
			}
			System.out.println( );
		}
		
		//2
//      Output:		
//		11111
//		22222
//		33333
//		44444
//		55555

	}

}
