package problems.SlidingWindow;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SlidingWindowMaximumTest {
    private final SlidingWindowMaximum solution = new SlidingWindowMaximum();

    @Test
    void testMaxSlidingWindow() {
        assertArrayEquals(new int[]{3,3,5,5,6,7}, solution.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3));
        assertArrayEquals(new int[]{1}, solution.maxSlidingWindow(new int[]{1}, 1));
        assertArrayEquals(new int[]{1,2,3}, solution.maxSlidingWindow(new int[]{1,2,3}, 1));
        assertArrayEquals(new int[]{3,3,2}, solution.maxSlidingWindow(new int[]{1,3,1,2}, 2));
    }
}