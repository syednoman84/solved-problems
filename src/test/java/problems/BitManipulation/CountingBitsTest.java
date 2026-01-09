package problems.BitManipulation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CountingBitsTest {
    private final CountingBits solution = new CountingBits();

    @Test
    void testCountBits() {
        assertArrayEquals(new int[]{0,1,1}, solution.countBits(2));
        assertArrayEquals(new int[]{0,1,1,2,1,2}, solution.countBits(5));
        assertArrayEquals(new int[]{0}, solution.countBits(0));
        assertArrayEquals(new int[]{0,1}, solution.countBits(1));
        assertArrayEquals(new int[]{0,1,1,2,1,2,2,3}, solution.countBits(7));
    }
}