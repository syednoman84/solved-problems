package problems.Graphs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NumberOfIslandsTest {

    @Test
    void testNumIslands() {
        NumberOfIslands solution = new NumberOfIslands();
        
        // Test case 1: Multiple islands
        char[][] grid1 = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };
        assertEquals(3, solution.numIslands(grid1));
        
        // Test case 2: Single large island
        char[][] grid2 = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };
        assertEquals(1, solution.numIslands(grid2));
        
        // Test case 3: No islands
        char[][] grid3 = {
            {'0','0','0','0'},
            {'0','0','0','0'}
        };
        assertEquals(0, solution.numIslands(grid3));
        
        // Test case 4: All islands
        char[][] grid4 = {
            {'1','1','1'},
            {'1','1','1'}
        };
        assertEquals(1, solution.numIslands(grid4));
        
        // Test case 5: Single cell island
        char[][] grid5 = {{'1'}};
        assertEquals(1, solution.numIslands(grid5));
        
        // Test case 6: Single cell water
        char[][] grid6 = {{'0'}};
        assertEquals(0, solution.numIslands(grid6));
    }
}