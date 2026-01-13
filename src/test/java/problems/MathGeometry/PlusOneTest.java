package problems.MathGeometry;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlusOneTest {
    private final PlusOne solution = new PlusOne();

    @Test
    void testPlusOne() {
        assertArrayEquals(new int[]{1,2,4}, solution.plusOne(new int[]{1,2,3}));
        assertArrayEquals(new int[]{4,3,2,2}, solution.plusOne(new int[]{4,3,2,1}));
        assertArrayEquals(new int[]{1,0}, solution.plusOne(new int[]{9}));
        assertArrayEquals(new int[]{1,0,0,0}, solution.plusOne(new int[]{9,9,9}));
    }
}