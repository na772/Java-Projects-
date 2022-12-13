package Test;

import static org.junit.jupiter.api.Assertions.*;
import Java.GuessingNumber;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class GuessingNumberTest {
    GuessingNumber guessTest;
    @BeforeEach
    void setUp()
    {
        guessTest = new GuessingNumber();
    }
    @Test
    void testOne() {
        int output = guessTest.guessNumber(1);
        assertEquals(1, output);
    }
    @Test
    void testTwo() {
        int output = guessTest.guessNumber(2);
        assertEquals(2, output);
    }
    @Test
    void testThree() {
        int output = guessTest.guessNumber(3);
        assertEquals(3, output);
    }
    @Test
    void testFour() {
        int  output = guessTest.guessNumber(5);
        assertEquals(5, output);
    }
    @Test
    void testFive() {
        int output = guessTest.guessNumber(5);
        assertEquals(5, output);
    }
    @Test
    void testSix() {
        int output = guessTest.guessNumber(6);
        assertEquals(6, output);
    }
    @Test
    void testSeven() {
        int output = guessTest.guessNumber(7);
        assertEquals(7, output);
    }
    @Test
    void testEight() {
        int output = guessTest.guessNumber(8);
        assertEquals(8, output);
    }
    @Test
    void testNine() {
        int output = guessTest.guessNumber(9);
        assertEquals(9, output);
    }
    @Test
    void testTen() {
        int output = guessTest.guessNumber(10);
        assertEquals(10, output);
    }
    @Test
    void testEleven() {
        int output = guessTest.guessNumber(11);
        assertEquals(11, output);
    }
    @Test
    void testTwelve() {
        int output = guessTest.guessNumber(12);
        assertEquals(12, output);
    }
    @Test
    void testThirteen() {
        int output = guessTest.guessNumber(13);
        assertEquals(13, output);
    }
    @Test
    void testFourteen() {
        int output = guessTest.guessNumber(14);
        assertEquals(14, output);
    }
    @Test
    void testFifteen() {
        int output = guessTest.guessNumber(15);
        assertEquals(15, output);
    }
    @Test
    void testSixteen() {
        int  output = guessTest.guessNumber(16);
        assertEquals(16, output);
    }
    @Test
    void testSeventeen() {
        int output = guessTest.guessNumber(17);
        assertEquals(17, output);
    }
    @Test
    void testEighteen() {
        int output = guessTest.guessNumber(18);
        assertEquals(18, output);
    }
    @Test
    void testNineteen() {
        int output = guessTest.guessNumber(19);
        assertEquals(19, output);
    }
    @Test
    void testTwenty() {
        int  output = guessTest.guessNumber(20);
        assertEquals(20, output);
    }
    @AfterEach
    void tearDown()
    {
    }
}