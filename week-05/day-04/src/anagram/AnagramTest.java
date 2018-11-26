package anagram;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnagramTest {

    Anagram anagram;

    @BeforeEach
    void setUp() {
        anagram = new Anagram();
    }

    @Test
    void isAnagramFail() {
        assertEquals(false, anagram.isAnagram("apple", "pear"));
    }

    @Test
    void isAnagramFailEmpty() {
        assertEquals(false, anagram.isAnagram("", "pear"));
    }

    @Test
    void isAnagramFailNull() {
        assertEquals(false, anagram.isAnagram(null, "pear"));
    }

    @Test
    void isAnagramFailDiffLength() {
        assertEquals(false, anagram.isAnagram("aaa", "aaaa"));
    }

    @Test
    void isAnagramPass() {
        assertEquals(true, anagram.isAnagram("baba", "abba"));
    }
}