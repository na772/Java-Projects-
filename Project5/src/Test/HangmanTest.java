package Test;

import static org.junit.jupiter.api.Assertions.*;

import Java.Hangman;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class HangmanTest
{
    List<Character> carhList;
    String word;
    @BeforeEach
    void setUp()
    {
        carhList = new ArrayList<>();
        word = "secret";
    }
    @Test
    void test1()
    {
        boolean output1 = Hangman.printSecretWord(word , carhList);
        assertEquals(false, output1);
    }
    @Test
    void test2()
    {
        boolean output2 = Hangman.getGuessedLetter(word , carhList);
        assertEquals(true, output2);
    }
    @AfterEach
    void tearDown()
    {
    }

}