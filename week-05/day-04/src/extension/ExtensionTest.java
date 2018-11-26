package extension;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


class ExtensionTest {
//    Run the tests, all 10 should be green (passing).
//    The implementations though are not quite good.
//    Create tests that'll fail, and will show how the implementations are wrong
//    After creating the tests, fix the implementations
//    Check again, if you can create failing tests
//    Implement if needed

    Extension extension = new Extension();

    @Test
    void testAdd_2and3is5() {
        assertEquals(5, extension.add(2, 3));
    }

    @Test
    void testAdd_10and1is11() {
        assertEquals(11, extension.add(10, 1));
    }

    @Test
    void testAdd_1and4is5() {
        assertEquals(5, extension.add(1, 4));
    }

    @Test
    void testMaxOfThree_first() {
        assertEquals(5, extension.maxOfThree(5, 4, 3));
    }

    @Test
    void testMaxOfThree_second() {
        assertEquals(6, extension.maxOfThree(5, 6, 3));
    }

    @Test
    void testMaxOfThree_third() {
        assertEquals(10, extension.maxOfThree(6, 2, 10));
    }

    @Test
    void testMaxOfThree_withEquals() {
        assertEquals(10, extension.maxOfThree(6, 6, 10));
    }

    @Test
    void testMedian_fail() {
        assertEquals(10, extension.median(Arrays.asList(7, 10, 8, 9, 11, 12, 13)));
    }

    @Test
    void testMedian_four() {
        assertEquals(5, extension.median(Arrays.asList(7, 5, 3, 5)));
    }

    @Test
    void testMedian_five() {
        assertEquals(3, extension.median(Arrays.asList(1, 2, 3, 4, 5)));
    }

    @Test
    void testIsVowel_a() {
        assertTrue(extension.isVowel('a'));
    }

    @Test
    void testIsVowel_u() {
        assertTrue(extension.isVowel('u'));
    }

    @Test
    void testTranslate_kalap() {
        assertEquals("kavalavap", extension.translate("kalap"));
    }

    @Test
    void testTranslate_bemutatkozik() {
        assertEquals("bevemuvutavatkovozivik", extension.translate("bemutatkozik"));
    }

    @Test
    void testTranslate_lagopus() {
        assertEquals("lavagovopuvus", extension.translate("lagopus"));
    }

    @Test
    void testTranslate_kutya() {
        assertEquals("kuvutyava", extension.translate("kutya"));
    }
}