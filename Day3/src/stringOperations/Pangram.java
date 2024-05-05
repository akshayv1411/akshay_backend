package stringOperations;

public class Pangram {


    public static boolean isPangram(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }

        str = str.toLowerCase();

        boolean[] alphabets = new boolean[26];

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                alphabets[ch - 'a'] = true;
            }
        }

        for (boolean alphabet : alphabets) {
            if (!alphabet) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String str = "'The quick brown fox jumps over the lazy dog'";
        boolean isPangram = isPangram(str);
        System.out.println( str + " is a pangram ------->" + isPangram);
    }
}

