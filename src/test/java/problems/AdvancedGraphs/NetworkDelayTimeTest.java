package problems.AdvancedGraphs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NetworkDelayTimeTest {
    private final NetworkDelayTime solution = new NetworkDelayTime();

    @Test
    void testNetworkDelayTime() {
        assertEquals(2, solution.networkDelayTime(new int[][]{{2,1,1},{2,3,1},{3,4,1}}, 4, 2));
        assertEquals(1, solution.networkDelayTime(new int[][]{{1,2,1}}, 2, 1));
        assertEquals(-1, solution.networkDelayTime(new int[][]{{1,2,1}}, 2, 2));
        assertEquals(0, solution.networkDelayTime(new int[][]{}, 1, 1));
        assertEquals(3, solution.networkDelayTime(new int[][]{{1,2,1},{2,3,2}}, 3, 1));
    }
}