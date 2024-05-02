package pattern;

public class Pattern9 {

	public static void main(String[] args) {
		int num = 5;


		for(int i=0; i<num; i++) {
			char ch = 'a';
			for(int j=0;j<num;j++) {
				System.out.print(ch++);
			}
			System.out.println();
			
		}

	}
	
	
//	output
//	abcde
//	abcde
//	abcde
//	abcde
//	abcde


}
