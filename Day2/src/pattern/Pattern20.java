package pattern;

public class Pattern20 {

	public static void main(String[] args) {
		int x =1;
		int num =5;
		for(int i=1; i<=num; i++) {
			for(int j = 1; j <= num-i; j++) {
				System.out.print("  ");
			}

			for(int j = 1; j <= 2*i-1; j++) {
				System.out.print(x % 2 + " ");
			}
			x++;
			System.out.println();
		}
		
		
//		   output:
//	          1 
//	        0 0 0 
//	      1 1 1 1 1 
//	    0 0 0 0 0 0 0 
//	  1 1 1 1 1 1 1 1 1 

	}

}
