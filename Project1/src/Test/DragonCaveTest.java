package Test;
import static org.junit.jupiter.api.Assertions.*;
import Java.DragonCave;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class DragonCaveTest {
    DragonCave test;
    @BeforeEach
    void setUp()
    {
        test = new DragonCave();
    }
    @Test
    void testOne()
    {
        int output = test.chooseCave(1);
        assertEquals(1, output);
    }

    @Test
    void testTwo()
    {
        int output = test.chooseCave(2);
        assertEquals(2, output);
    }
    @AfterEach
    void tearDown()
    {
    }
}