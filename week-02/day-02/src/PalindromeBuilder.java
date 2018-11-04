public class PalindromeBuilder {

    public static void main(String[] args) {

        System.out.println(palindromeBuilder("Roller"));
    }


    public static String palindromeBuilder(String word) {

        String reversedWord = "";
        for (int i =word.length()-1; i >= 0; i--) {
            reversedWord += word.charAt(i);
        }

        String palindrome = word + reversedWord;
        return palindrome;
    }
}

