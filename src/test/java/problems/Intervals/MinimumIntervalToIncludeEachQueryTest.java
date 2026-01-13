package problems.Intervals;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MinimumIntervalToIncludeEachQueryTest {
    private final MinimumIntervalToIncludeEachQuery solution = new MinimumIntervalToIncludeEachQuery();

    @Test
    void testMinInterval() {
        assertArrayEquals(new int[]{2,2,3,5,1,-1}, solution.minInterval(new int[][]{{1,3},{2,3},{3,7},{6,6}}, new int[]{2,3,1,7,6,8}));
        assertArrayEquals(new int[]{2,-1,4}, solution.minInterval(new int[][]{{2,3},{2,5},{1,8},{20,25}}, new int[]{2,19,5}));
        assertArrayEquals(new int[]{4}, solution.minInterval(new int[][]{{1,4},{2,4},{3,6},{4,4}}, new int[]{5}));
    }
}