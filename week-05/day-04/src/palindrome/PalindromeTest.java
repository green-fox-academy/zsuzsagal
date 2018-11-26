package palindrome;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeTest {

    Palindrome palindrome;

    @BeforeEach
    void setUp() {
        palindrome = new Palindrome();
    }

    @Test
    void isPalindrome() {
        String word1ToTest = "madam";
        String word2ToTest = "madam";
        boolean expectedResult = true;
        assertTrue(expectedResult == palindrome.isPalindrome(word1ToTest,word2ToTest));
    }
}