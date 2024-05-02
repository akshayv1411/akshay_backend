package pattern;

public class Pattern27 {

    public static void main(String[] args) {
        int n = 5;
        Pattern27 p = new Pattern27();
        p.printPattern(n);
    }

    public void printPattern(int n) {
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }


            for (int j = i; j >= 1; j--) {
                System.out.print(j + " ");
            }

            System.out.println();
        }
    }
//    output:
//        1 
//      2 1 
//    3 2 1 
//  4 3 2 1 
//5 4 3 2 1 
}

