package problems.Intervals;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NonOverlappingIntervalsTest {
    private final NonOverlappingIntervals solution = new NonOverlappingIntervals();

    @Test
    void testEraseOverlapIntervals() {
        assertEquals(1, solution.eraseOverlapIntervals(new int[][]{{1,2},{2,3},{3,4},{1,3}}));
        assertEquals(2, solution.eraseOverlapIntervals(new int[][]{{1,2},{1,2},{1,2}}));
        assertEquals(0, solution.eraseOverlapIntervals(new int[][]{{1,2},{2,3}}));
        assertEquals(0, solution.eraseOverlapIntervals(new int[][]{{1,2}}));
    }
}