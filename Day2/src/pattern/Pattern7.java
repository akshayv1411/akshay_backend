package pattern;

public class Pattern7 {

	public static void main(String[] args) {
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 5; j++) {
				if (j % 2 == 0) {
					System.out.print(0);
				} else {
					System.out.print(1);
				}
			}
			System.out.println();
		}
		//6
//	Output:	
//	10101
//	10101
//	10101
//	10101
//	10101

	}

}
