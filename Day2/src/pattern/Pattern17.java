package pattern;

public class Pattern17 {

	public static void main(String[] args) {
		int num = 5;	
		
		for(int i=1; i<num+1; i++) {

			for(int j=1; j<=i; j++) {
				System.out.print(i);
			}
			
			System.out.println();
		}

	}

}
