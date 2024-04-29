package demo;

public class Pattern {
	/* 1 1 1 1 1 
	 * 2 2 2 2 2
	 * 3 3 3 3 3 
	 * 4 4 4 4 4
	 * 5 5 5 5 5 
	 */
	
	/* 1 2 3 4 5 
	 * 1 2 3 4 5 
	 * 1 2 3 4 5 
	 * 1 2 3 4 5 
	 * 1 2 3 4 5
	 */

	public static void main(String[] args) {
	int n = 5;
	
	
	for(int i = 1; i <=n; i++) {
		int k = i;
		for(int j=1 ; j<= 1 ; j++) {
			System.out.print(k++);
		}
		System.out.println();
	}
}
}
