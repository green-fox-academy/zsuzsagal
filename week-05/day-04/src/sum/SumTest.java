package sum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SumTest {
//    Follow these steps:
//    Add a new test case
//    Instantiate your class
//    create a list of integers
//    use the assertEquals to test the result of the created sum method, Run them
//    Create different tests where you test your method with an empty list
//    with a list with one element in it
//    with multiple elements in it
//    with a null
//    Run them
//    Fix your code if needed

    Sum sum;

    @BeforeEach
    void setUp() {
        sum = new Sum();
    }

    @Test
    void testSum() {
        int expectedResult = 150;
        ArrayList<Integer> numbers = new ArrayList<Integer>(Arrays.asList(4, 28, 7, 10, 15, 86));
        assertEquals(expectedResult, sum.sumOfArray(numbers));
    }

    @Test
    void testSumWithEmptyList() {
        int expectedResult = 0;
        ArrayList<Integer> numbers = new ArrayList<Integer>(Arrays.asList());
        assertEquals(expectedResult, sum.sumOfArray(numbers));
    }

    @Test
    void testSumWithOneElement() {
        ArrayList<Integer> numbers = new ArrayList<Integer>(Arrays.asList(86));
        int expectedResult = numbers.get(0);
        assertEquals(expectedResult, sum.sumOfArray(numbers));
    }

    @Test
    void testSumWithNull() {
        int expectedResult = 0;
        assertEquals(expectedResult, sum.sumOfArray(null));
    }
}