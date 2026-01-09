package problems.AdvancedGraphs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MinCostToConnectAllPointsTest {
    private final MinCostToConnectAllPoints solution = new MinCostToConnectAllPoints();

    @Test
    void testMinimumCost() {
        assertEquals(20, solution.minimumCost(new int[][]{{0,0},{2,2},{3,10},{5,2},{7,0}}));
        assertEquals(18, solution.minimumCost(new int[][]{{3,12},{-2,5},{-4,1}}));
        assertEquals(0, solution.minimumCost(new int[][]{{0,0}}));
        assertEquals(2, solution.minimumCost(new int[][]{{0,0},{1,1}}));
        assertEquals(3, solution.minimumCost(new int[][]{{0,0},{1,0},{0,1},{1,1}}));
    }
}