package palindrome;

public class Palindrome {
//    Write a function, that takes two strings and returns a boolean value based on if the two strings are Anagramms or not.
//    Create a test for that.

    public boolean isPalindrome(String word1, String word2) {
        String reverse = "";
        for (int i = word1.length(); i > 0; i--) {
            reverse += i;
        }
        return word1.equals(word2);
    }

    public static void main(String[] args) {
        Palindrome a = new Palindrome();
        System.out.println(a.isPalindrome("madam", "madam"));
    }
}
