package pattern;

public class Pattern11 {
	public static void main(String[] args) {
		int num = 5;
		
		for(int i = 1 ; i < num+1; i++) {
			int num2 = 5;
			for(int j = 1; j<num+1; j++) {
				System.out.print(num2--);
			}
			System.out.println();
		}
	}
	
	
//	output
//	54321
//	54321
//	54321
//	54321
//	54321

}
