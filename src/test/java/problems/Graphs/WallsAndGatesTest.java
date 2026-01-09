package problems.Graphs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WallsAndGatesTest {

    @Test
    void testIslandsAndTreasure() {
        WallsAndGates solution = new WallsAndGates();
        final int INF = 2147483647;
        
        // Test case 1: Standard example
        int[][] grid1 = {
            {INF, -1, 0, INF},
            {INF, INF, INF, -1},
            {INF, -1, INF, -1},
            {0, -1, INF, INF}
        };
        int[][] expected1 = {
            {3, -1, 0, 1},
            {2, 2, 1, -1},
            {1, -1, 2, -1},
            {0, -1, 3, 4}
        };
        solution.islandsAndTreasure(grid1);
        assertArrayEquals(expected1, grid1);
        
        // Test case 2: Simple case
        int[][] grid2 = {
            {0, -1},
            {INF, INF}
        };
        int[][] expected2 = {
            {0, -1},
            {1, 2}
        };
        solution.islandsAndTreasure(grid2);
        assertArrayEquals(expected2, grid2);
        
        // Test case 3: No gates
        int[][] grid3 = {
            {INF, INF},
            {INF, INF}
        };
        int[][] expected3 = {
            {INF, INF},
            {INF, INF}
        };
        solution.islandsAndTreasure(grid3);
        assertArrayEquals(expected3, grid3);
        
        // Test case 4: All walls
        int[][] grid4 = {
            {-1, -1},
            {-1, -1}
        };
        int[][] expected4 = {
            {-1, -1},
            {-1, -1}
        };
        solution.islandsAndTreasure(grid4);
        assertArrayEquals(expected4, grid4);
        
        // Test case 5: Single gate
        int[][] grid5 = {{0}};
        int[][] expected5 = {{0}};
        solution.islandsAndTreasure(grid5);
        assertArrayEquals(expected5, grid5);
        
        // Test case 6: Multiple gates
        int[][] grid6 = {
            {0, INF, 0},
            {INF, INF, INF},
            {0, INF, 0}
        };
        int[][] expected6 = {
            {0, 1, 0},
            {1, 2, 1},
            {0, 1, 0}
        };
        solution.islandsAndTreasure(grid6);
        assertArrayEquals(expected6, grid6);
    }
}