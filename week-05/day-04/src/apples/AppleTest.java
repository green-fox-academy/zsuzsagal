package apples;

import static org.junit.jupiter.api.Assertions.*;

class AppleTest {

    Apple appleresult;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
         appleresult= new Apple();
    }

    @org.junit.jupiter.api.Test
    void testGetApple() {
        String printApple = "apple";
        assertEquals(printApple,appleresult.getApple());
    }
}

