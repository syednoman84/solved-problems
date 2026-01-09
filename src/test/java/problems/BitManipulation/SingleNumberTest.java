package problems.BitManipulation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SingleNumberTest {
    private final SingleNumber solution = new SingleNumber();

    @Test
    void testSingleNumber() {
        assertEquals(1, solution.singleNumber(new int[]{2,2,1}));
        assertEquals(4, solution.singleNumber(new int[]{4,1,2,1,2}));
        assertEquals(1, solution.singleNumber(new int[]{1}));
        assertEquals(0, solution.singleNumber(new int[]{0,1,1}));
        assertEquals(-1, solution.singleNumber(new int[]{-1,2,2}));
    }
}