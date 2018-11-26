package anagram;

import java.util.HashMap;

public class Anagram {
//    Write a function, that takes two strings and returns a boolean value based on if the two strings are Anagramms or not.
//    Create a test for that.

    private HashMap charCount(String input) {
        HashMap<Character, Integer> wordMap = new HashMap<>();
        char[] strArray = input.toCharArray();

        for (char c : strArray) {
            if (wordMap.containsKey(c)) {
                wordMap.put(c, wordMap.get(c) + 1);
            } else {
                wordMap.put(c, 1);
            }
        }
        return wordMap;
    }

    public boolean isAnagram(String word1, String word2) {
        if (!(word1 instanceof String) || (!(word2 instanceof String))) {
            return false;
        }

        HashMap<Character, Integer> wordMap1 = charCount(word1);
        HashMap<Character, Integer> wordMap2 = charCount(word2);

        return wordMap1.equals(wordMap2);
    }
}

