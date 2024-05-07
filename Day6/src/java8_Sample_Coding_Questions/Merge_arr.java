package java8_Sample_Coding_Questions;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Merge_arr {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5};
        int[] b = new int[]{9, 8, 7, 6, 5};
        int[] mergedArray = IntStream.concat(Arrays.stream(a), Arrays.stream(b))
                                    .sorted()
                                    .toArray();
        System.out.println("Merged and Sorted Array: " + Arrays.toString(mergedArray));
    }
}
