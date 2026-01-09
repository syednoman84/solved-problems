package problems.BitManipulation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SumOfTwoIntegersTest {
    private final SumOfTwoIntegers solution = new SumOfTwoIntegers();

    @Test
    void testGetSum() {
        assertEquals(3, solution.getSum(1, 2));
        assertEquals(5, solution.getSum(2, 3));
        assertEquals(0, solution.getSum(0, 0));
        assertEquals(5, solution.getSum(5, 0));
        assertEquals(-1, solution.getSum(-1, 0));
    }
}