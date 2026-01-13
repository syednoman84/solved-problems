package problems.TwoPointer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TwoSumIITest {
    private final TwoSumII solution = new TwoSumII();

    @Test
    void testTwoSum() {
        assertArrayEquals(new int[]{1,2}, solution.twoSum(new int[]{2,7,11,15}, 9));
        assertArrayEquals(new int[]{1,3}, solution.twoSum(new int[]{2,3,4}, 6));
        assertArrayEquals(new int[]{1,2}, solution.twoSum(new int[]{-1,0}, -1));
        assertArrayEquals(new int[]{1,2}, solution.twoSum(new int[]{1,2}, 3));
    }
}