package stringOperations;

public class CountChar {

    public static void countEachCharacter(String str) {

        int[] charCount = new int[26];
        

        str = str.toLowerCase();
        

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                charCount[ch - 'a']++;
            }
        }
        
        System.out.println("Character Counts:");
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (charCount[ch - 'a'] > 0) {
                System.out.println(ch + ": " + charCount[ch - 'a']);
            }
        }
    }

    public static void main(String[] args) {
        String str = "Sachin";
        countEachCharacter(str);
    }
}


