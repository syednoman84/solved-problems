package problems.Intervals;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MergeIntervalTest {
    private final MergeInterval solution = new MergeInterval();

    @Test
    void testMerge() {
        assertArrayEquals(new int[][]{{1,6},{8,10},{15,18}}, solution.merge(new int[][]{{1,3},{2,6},{8,10},{15,18}}));
        assertArrayEquals(new int[][]{{1,5}}, solution.merge(new int[][]{{1,4},{4,5}}));
        assertArrayEquals(new int[][]{{1,4}}, solution.merge(new int[][]{{1,4}}));
        assertArrayEquals(new int[][]{{0,4}}, solution.merge(new int[][]{{1,4},{0,4}}));
    }
}