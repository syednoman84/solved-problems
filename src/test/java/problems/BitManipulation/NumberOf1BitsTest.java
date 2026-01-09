package problems.BitManipulation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NumberOf1BitsTest {
    private final NumberOf1Bits solution = new NumberOf1Bits();

    @Test
    void testHammingWeight() {
        assertEquals(3, solution.hammingWeight(11));
        assertEquals(1, solution.hammingWeight(128));
        assertEquals(31, solution.hammingWeight(-3));
        assertEquals(0, solution.hammingWeight(0));
        assertEquals(1, solution.hammingWeight(1));
    }
}