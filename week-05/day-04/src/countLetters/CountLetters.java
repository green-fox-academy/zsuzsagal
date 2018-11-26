package countLetters;

import java.util.HashMap;

public class CountLetters {
// Write a function, that takes a string as an argument and returns a dictionary with all letters in the string as keys,
// and numbers as values that shows how many occurrences there are.
// Create a test for that.

    public HashMap<Character, Integer> countLetters(String input) {

        if (!(input instanceof String)) {
            return null;
        }

        HashMap<Character, Integer> dictionary = new HashMap<>();
        char[] strArray = input.toCharArray();

        for (char c : strArray) {
            if (dictionary.containsKey(c)) {
                dictionary.put(c, dictionary.get(c) + 1);
            } else {
                dictionary.put(c, 1);
            }
        }

        System.out.println(dictionary);
        return dictionary;
    }

    public static void main(String[] args) {
        CountLetters cl = new CountLetters();
        cl.countLetters("banana");
    }
}
