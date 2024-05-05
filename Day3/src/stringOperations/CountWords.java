package stringOperations;

public class CountWords {

    public static int countWords(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        int count = 1;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String str = "'Good Night'";
        int wordCount = countWords(str);
        System.out.println("The words in the string " + str + " is: " + wordCount);
    }
}

