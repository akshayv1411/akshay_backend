package pattern;

public class Pattern28 {

    public static void main(String[] args) {
        int n = 5;
        Pattern28 p = new Pattern28();
        p.printPattern(n);
    }

    public void printPattern(int n) {

        int x = 1;

        for (int i = 1; i <= n; i++) {

            int num = x;
            for (int j = 1; j <= i; j++) {
                System.out.print(num + " ");
                num += n - j;
            }

            System.out.println();
            x++;
        }
    }
}

