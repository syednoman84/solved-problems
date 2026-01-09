package problems.BitManipulation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ReverseBitsTest {
    private final ReverseBits solution = new ReverseBits();

    @Test
    void testReverseBits() {
        assertEquals(964176192, solution.reverseBits(43261596));
        assertEquals(-1073741825, solution.reverseBits(-3));
        assertEquals(0, solution.reverseBits(0));
        assertEquals(-2147483648, solution.reverseBits(1));
        assertEquals(1073741824, solution.reverseBits(2));
    }
}