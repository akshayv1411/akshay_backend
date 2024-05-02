package pattern;

public class Pattern22 {
	public static void main(String[] args) {
		int x =1;
		int num =5;
		for(int i=1; i<=num; i++) {
			for(int j = 1; j <= num-i; j++) {
				System.out.print("  ");
			}

			for(int j = 1; j <= 2*i-1; j++) {
				System.out.print(j % 10 + " ");
				x++;
			}
			System.out.println();
		}
		
//		    output:
//	          1 
//	        1 2 3 
//	      1 2 3 4 5 
//	    1 2 3 4 5 6 7 
//	  1 2 3 4 5 6 7 8 9 
		
	}
}
