package problems.TwoPointer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContainerWithMostWaterTest {
    private final ContainerWithMostWater solution = new ContainerWithMostWater();

    @Test
    void testMaxArea() {
        assertEquals(49, solution.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        assertEquals(1, solution.maxArea(new int[]{1,1}));
        assertEquals(16, solution.maxArea(new int[]{4,3,2,1,4}));
        assertEquals(2, solution.maxArea(new int[]{1,2,1}));
    }
}