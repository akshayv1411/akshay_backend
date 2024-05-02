package pattern;

public class Pattern8 {
	public static void main(String[] args) {
		int num = 5;
		
		for(int i=1; i<num+1; i++) {
			char ch = 'A';
			for(int j=1; j<num+1; j++) {
				System.out.print(ch++);
			}
			System.out.println( );
		}
	}
	
//		Output:
//		ABCDE
//		ABCDE
//		ABCDE
//		ABCDE
//		ABCDE
//	
	
	

}
