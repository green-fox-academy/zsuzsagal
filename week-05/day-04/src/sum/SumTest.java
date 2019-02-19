package sum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class SumTest {

    Sum sum;

    @BeforeEach
    void setUp() {
        sum = new Sum();
    }

    @Test
    void testSum() {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(4, 28, 7, 10, 15, 86));
        int result = sum.sumOfArray(numbers);
        assertEquals(150, result);
    }

    @Test
    void testSumWithEmptyList() {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList());
        int result = sum.sumOfArray(numbers);
        assertEquals(0,result );
    }

    @Test
    void testSumWithOneElement() {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(86));
        int result = sum.sumOfArray(numbers);
        assertEquals(86, result);
    }

    @Test
    void testSumWithNull() {
        int result = sum.sumOfArray(null);
        assertEquals(0, result);
    }

}
