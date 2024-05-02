package pattern;

import java.util.Scanner;

public class Pattern30 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows for the pyramid: ");
        int numRows = scanner.nextInt();
        printNumberPyramid(numRows);
        scanner.close();
    }

    public static void printNumberPyramid(int numRows) {
        int numCols = numRows * 2 - 1;

        for (int i = 1; i <= numRows; i++) {
            // Print leading spaces
            for (int j = 1; j <= numCols - i; j++) {
                System.out.print(" ");
            }

            // Print numbers increasing from i to 2 * i - 1
            for (int j = i; j < 2 * i; j++) {
                System.out.print(i + " ");
            }

            System.out.println();
        }
    }
}

