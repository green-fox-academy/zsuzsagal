package countLetters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class CountLettersTest {

    CountLetters countLetters;

    @BeforeEach
    void setUp() {
        countLetters = new CountLetters();
    }

    @Test
    void countLetters() {
        String input = "character";
        HashMap<Character, Integer> expectedResult = new HashMap<>();

        expectedResult.put('a', 2);
        expectedResult.put('c', 2);
        expectedResult.put('h', 1);
        expectedResult.put('e', 1);
        expectedResult.put('r', 2);
        expectedResult.put('t', 1);

        HashMap<Character, Integer> actualResult = countLetters.countLetters(input);
        assertEquals(expectedResult, actualResult);
    }


    @Test
    void countLettersWithoutRepeat() {
        String input = "abcdef";
        HashMap<Character, Integer> expectedResult = new HashMap<>();

        expectedResult.put('a', 1);
        expectedResult.put('b', 1);
        expectedResult.put('c', 1);
        expectedResult.put('d', 1);
        expectedResult.put('e', 1);
        expectedResult.put('f', 1);

        HashMap<Character, Integer> actualResult = countLetters.countLetters(input);
        assertEquals(expectedResult, actualResult);
    }


    @Test
    void countLettersTestWithEmptyString() {
        HashMap<Character, Integer> expectedResult = new HashMap<>();
        HashMap<Character, Integer> actualResult = countLetters.countLetters("");
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void countLettersTestWithOneChar() {
        HashMap<Character, Integer> expectedResult = new HashMap<>();
        expectedResult.put('f', 1);
        HashMap<Character, Integer> actualResult = countLetters.countLetters("f");
        assertEquals(expectedResult, actualResult);
    }


    @Test
    void countLettersTestWithOneCharMultiple() {
        HashMap<Character, Integer> expectedResult = new HashMap<>();
        expectedResult.put('f', 5);
        HashMap<Character, Integer> actualResult = countLetters.countLetters("fffff");
        assertEquals(expectedResult, actualResult);
    }


    @Test
    void countLettersTestWithNull() {
        HashMap<Character, Integer> expectedResult = null;
        HashMap<Character, Integer> actualResult = countLetters.countLetters(null);
        assertEquals(expectedResult, actualResult);
    }
}
