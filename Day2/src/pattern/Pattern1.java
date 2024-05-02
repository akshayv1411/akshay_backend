package pattern;

public class Pattern1 {

	public static void main(String[] args) {
		int num = 5;
		
		for(int i=1; i<num+1; i++) {
			for(int j=1; j<num+1; j++) {
				System.out.print(j);
			}
			System.out.println( );
		}
		
		// 1
//      Output:		
//		12345
//		12345
//		12345
//		12345
//		12345
	}

}
