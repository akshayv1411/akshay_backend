package stringOperations;

public class Vowels {

    public static boolean isAllVowels(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        str = str.toLowerCase();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u') {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String str = "'Sachin'";
        boolean containsAllVowels = isAllVowels(str);
        System.out.println(str + " is Not contain all vowels ----------> " + containsAllVowels);
    }
}

