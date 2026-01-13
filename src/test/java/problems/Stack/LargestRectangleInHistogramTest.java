package problems.Stack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LargestRectangleInHistogramTest {
    private final LargestRectangleInHistogram solution = new LargestRectangleInHistogram();

    @Test
    void testLargestRectangleArea() {
        assertEquals(10, solution.largestRectangleArea(new int[]{2,1,5,6,2,3}));
        assertEquals(4, solution.largestRectangleArea(new int[]{2,4}));
        assertEquals(3, solution.largestRectangleArea(new int[]{1,1,1}));
        assertEquals(3, solution.largestRectangleArea(new int[]{2,1,2}));
    }
}