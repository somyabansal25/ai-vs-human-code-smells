// AI-generated style solution. Task: check if a string is a palindrome.

public class task02_palindrome {

    public static boolean isPalindrome(String input) {
        if (input == null) {
            return false;
        }
        String cleaned = "";
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                cleaned = cleaned + Character.toLowerCase(c);
            }
        }
        String reversed = "";
        for (int i = cleaned.length() - 1; i >= 0; i--) {
            reversed = reversed + cleaned.charAt(i);
        }
        if (cleaned.equals(reversed)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("Racecar"));
        System.out.println(isPalindrome("hello"));
    }
}
