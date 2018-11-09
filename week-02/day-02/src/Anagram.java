import java.util.Arrays;

public class Anagram {
    public static void main(String[] args) {
        //Create a function named is anagram following your current language's style guide.
        //It should take two strings and return a boolean value depending on whether its an anagram
        //or not.

        String wordA = "dog";
        String wordB = "god";

        System.out.println(anagram(wordA, wordB));
    }

    public static boolean anagram(String wordA, String wordB) {
        boolean isAnagram = false;

        char[] charArray1 = wordA.toCharArray();
        char[] charArray2 = wordB.toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        if (Arrays.equals(charArray1, charArray2)) {
            isAnagram = true;
        }
        return isAnagram;
    }
}


