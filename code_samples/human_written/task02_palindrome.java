// Human-written style solution. Task: check if a string is a palindrome.

public class task02_palindrome {

    public static boolean isPalindrome(String input) {
        if (input == null) return false;
        int i = 0, j = input.length() - 1;
        while (i < j) {
            if (input.charAt(i) != input.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("racecar"));
        System.out.println(isPalindrome("hello"));
    }
}
