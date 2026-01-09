package problems.Graphs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MaxAreaOfIslandTest {

    @Test
    void testMaxAreaOfIsland() {
        MaxAreaOfIsland solution = new MaxAreaOfIsland();
        
        // Test case 1: Multiple islands with different areas
        int[][] grid1 = {
            {0,0,1,0,0,0,0,1,0,0,0,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,1,1,0,1,0,0,0,0,0,0,0,0},
            {0,1,0,0,1,1,0,0,1,0,1,0,0},
            {0,1,0,0,1,1,0,0,1,1,1,0,0},
            {0,0,0,0,0,0,0,0,0,0,1,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        assertEquals(6, solution.maxAreaOfIsland(grid1));
        
        // Test case 2: No islands
        int[][] grid2 = {
            {0,0,0,0,0,0,0,0}
        };
        assertEquals(0, solution.maxAreaOfIsland(grid2));
        
        // Test case 3: Single cell island
        int[][] grid3 = {
            {0,0,0},
            {0,1,0},
            {0,0,0}
        };
        assertEquals(1, solution.maxAreaOfIsland(grid3));
        
        // Test case 4: Entire grid is one island
        int[][] grid4 = {
            {1,1,1},
            {1,1,1},
            {1,1,1}
        };
        assertEquals(9, solution.maxAreaOfIsland(grid4));
        
        // Test case 5: L-shaped island
        int[][] grid5 = {
            {1,1,0},
            {1,0,0},
            {1,0,0}
        };
        assertEquals(4, solution.maxAreaOfIsland(grid5));
        
        // Test case 6: Multiple small islands
        int[][] grid6 = {
            {1,0,1},
            {0,0,0},
            {1,0,1}
        };
        assertEquals(1, solution.maxAreaOfIsland(grid6));
    }
}