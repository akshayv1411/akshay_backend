package stringOperations;

public class CountVowels {

    public static void countVowels(String str) {
        if (str == null || str.isEmpty()) {
            System.out.println("The string is empty or null.");
            return;
        }
        str = str.toLowerCase();
        int vowelCount = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowelCount++;
            }
        }
        System.out.println("Vowels in the string is: " + vowelCount);
    }

    public static void main(String[] args) {
        String str = "Sachin";
        countVowels(str);
    }
}
