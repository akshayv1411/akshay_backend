package pattern;

public class Pattern10 {

	public static void main(String[] args) {
		int num = 5;
		char ch = 'a';
		for(int i=0; i<num;i++) {
			System.out.print(ch);			
			for(int j=0; j<num; j++) {
				System.out.print(ch);
				
			}
			ch++;
			System.out.println( );
		}

	}
	
	
//	output
//	aaaaaa
//	bbbbbb
//	cccccc
//	dddddd
//	eeeeee

}
