package problems.Graphs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Arrays;

class PacificAtlanticWaterFlowTest {

    @Test
    void testPacificAtlantic() {
        PacificAtlanticWaterFlow solution = new PacificAtlanticWaterFlow();
        
        // Test case 1: Standard example
        int[][] heights1 = {
            {1,2,2,3,5},
            {3,2,3,4,4},
            {2,4,5,3,1},
            {6,7,1,4,5},
            {5,1,1,2,4}
        };
        List<List<Integer>> result1 = solution.pacificAtlantic(heights1);
        assertEquals(7, result1.size());
        assertTrue(containsCoordinate(result1, 0, 4));
        assertTrue(containsCoordinate(result1, 1, 3));
        assertTrue(containsCoordinate(result1, 1, 4));
        assertTrue(containsCoordinate(result1, 2, 2));
        
        // Test case 2: Small grid where all cells can reach both oceans
        int[][] heights2 = {
            {2,1},
            {1,2}
        };
        List<List<Integer>> result2 = solution.pacificAtlantic(heights2);
        assertEquals(4, result2.size());
        
        // Test case 3: Single cell
        int[][] heights3 = {{1}};
        List<List<Integer>> result3 = solution.pacificAtlantic(heights3);
        assertEquals(1, result3.size());
        assertTrue(containsCoordinate(result3, 0, 0));
        
        // Test case 4: Uniform height - all cells should reach both oceans
        int[][] heights4 = {
            {1,1,1},
            {1,1,1},
            {1,1,1}
        };
        List<List<Integer>> result4 = solution.pacificAtlantic(heights4);
        assertEquals(9, result4.size());
        
        // Test case 5: Increasing heights from corners
        int[][] heights5 = {
            {1,2,3},
            {2,3,4},
            {3,4,5}
        };
        List<List<Integer>> result5 = solution.pacificAtlantic(heights5);
        assertTrue(result5.size() > 0);
        assertTrue(containsCoordinate(result5, 2, 2)); // Bottom-right should reach both
    }
    
    private boolean containsCoordinate(List<List<Integer>> result, int row, int col) {
        for (List<Integer> coord : result) {
            if (coord.get(0) == row && coord.get(1) == col) {
                return true;
            }
        }
        return false;
    }
}