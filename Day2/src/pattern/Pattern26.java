package pattern;

public class Pattern26 {

    public static void main(String[] args) {
        int n = 5;
        Pattern26 p = new Pattern26();
        p.printPyramid(n);
    }

    public void printPyramid(int n) {

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j < i; j++) {
                System.out.print("  ");
            }


            for (int j = 1; j <= 2 * (n - i) + 1; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }
    
//    		  output:
//    	* * * * * * * * * 
//    	  * * * * * * * 
//    	    * * * * * 
//    	      * * * 
//    	        * 

}


