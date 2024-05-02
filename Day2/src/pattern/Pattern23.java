package pattern;

public class Pattern23 {
	public static void main(String[] args) {
		int num =5;
		for(int i=1; i<=num; i++) {
			for(int j = 1; j <= num-i; j++) {
				System.out.print("  ");
			}

			for(int j = 0; j <= i-1; j++) {
				System.out.print("*" + " ");
				
			}
			System.out.println();
		}
	}
	
//	     output:
//	         * 
//	       * * 
//	     * * * 
//	   * * * * 
//	 * * * * * 
}
