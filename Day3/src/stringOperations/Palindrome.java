package stringOperations;

public class Palindrome {

    public static boolean isPalindrome(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }

        str = str.toLowerCase();

        int left = 0;
        int right = str.length() - 1;


        while (left < right) {

            while (left < right && !Character.isLetterOrDigit(str.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(str.charAt(right))) {
                right--;
            }


            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        String str = "Madam";
        boolean isPal = isPalindrome(str);
        System.out.println(str + " is palindrome");
    }
}

