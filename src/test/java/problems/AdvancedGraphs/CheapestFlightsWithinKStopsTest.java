package problems.AdvancedGraphs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CheapestFlightsWithinKStopsTest {
    private final CheapestFlightsWithinKStops solution = new CheapestFlightsWithinKStops();

    @Test
    void testFindCheapestPrice() {
        assertEquals(700, solution.findCheapestPrice(4, new int[][]{{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}}, 0, 3, 1));
        assertEquals(200, solution.findCheapestPrice(3, new int[][]{{0,1,100},{1,2,100},{0,2,500}}, 0, 2, 1));
        assertEquals(500, solution.findCheapestPrice(3, new int[][]{{0,1,100},{1,2,100},{0,2,500}}, 0, 2, 0));
        assertEquals(-1, solution.findCheapestPrice(3, new int[][]{{0,1,100}}, 0, 2, 1));
        assertEquals(100, solution.findCheapestPrice(2, new int[][]{{0,1,100}}, 0, 1, 0));
    }
}