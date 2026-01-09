package problems.Graphs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RottenOrangesTest {

    @Test
    void testOrangesRotting() {
        RottenOranges solution = new RottenOranges();
        
        // Test case 1: Standard case
        int[][] grid1 = {
            {2,1,1},
            {1,1,0},
            {0,1,1}
        };
        assertEquals(4, solution.orangesRotting(grid1));
        
        // Test case 2: Impossible case - isolated fresh orange
        int[][] grid2 = {
            {2,1,1},
            {0,1,1},
            {1,0,1}
        };
        assertEquals(-1, solution.orangesRotting(grid2));
        
        // Test case 3: No fresh oranges
        int[][] grid3 = {
            {0,2}
        };
        assertEquals(0, solution.orangesRotting(grid3));
        
        // Test case 4: All fresh oranges, no rotten
        int[][] grid4 = {
            {1,1,1},
            {1,1,1}
        };
        assertEquals(-1, solution.orangesRotting(grid4));
        
        // Test case 5: Single rotten orange
        int[][] grid5 = {
            {2}
        };
        assertEquals(0, solution.orangesRotting(grid5));
        
        // Test case 6: Mixed with empty cells
        int[][] grid6 = {
            {2,1,0,1},
            {0,0,1,1},
            {1,0,0,2}
        };
        assertEquals(-1, solution.orangesRotting(grid6));
        
        // Test case 7: Large grid with multiple rotten sources
        int[][] grid7 = {
            {2,1,1,1,1},
            {1,1,1,1,1},
            {1,1,1,1,2}
        };
        assertEquals(3, solution.orangesRotting(grid7));
    }
}