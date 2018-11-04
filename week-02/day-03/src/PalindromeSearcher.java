import java.util.ArrayList;

public class PalindromeSearcher {
    public static void main(String[] args) {
        // Create a function named search palindrome following your current language's style guide.
        // It should take a string, search for palindromes that at least 3 characters long
        // and return a list with the found palindromes.

        ArrayList<String> palindrome = palindrome("dog goat dad duck doodle never");
        System.out.print(palindrome);
    }


    public static boolean isPalindrome(String input) {
        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }


    public static ArrayList<String> palindrome(String word) {

        ArrayList<String> palindromes = new ArrayList<String>();

        for (int i = 0; i < word.length(); i++) {
            for (int j = i + 2; j < word.length(); j++) {
                if (word.charAt(i) == word.charAt(j)) {
                    String toCheck = word.substring(i, j+1);
                    if (isPalindrome(toCheck)) {
                        palindromes.add(toCheck);
                    }
                }
            }
        }
        return palindromes;

    }
}
