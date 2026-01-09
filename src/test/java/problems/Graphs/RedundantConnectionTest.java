package problems.Graphs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

class RedundantConnectionTest {

    @Test
    void testFindRedundantConnection() {
        RedundantConnection solution = new RedundantConnection();
        
        // Test case 1: Triangle graph
        int[][] edges1 = {{1,2},{1,3},{2,3}};
        int[] result1 = solution.findRedundantConnection(edges1);
        assertTrue(Arrays.equals(new int[]{2,3}, result1));
        
        // Test case 2: More complex graph
        int[][] edges2 = {{1,2},{2,3},{3,4},{1,4},{1,5}};
        int[] result2 = solution.findRedundantConnection(edges2);
        assertTrue(Arrays.equals(new int[]{1,4}, result2));
        
        // Test case 3: Simple cycle
        int[][] edges3 = {{1,2},{2,3},{1,3}};
        int[] result3 = solution.findRedundantConnection(edges3);
        assertTrue(Arrays.equals(new int[]{1,3}, result3));
        
        // Test case 4: Linear then cycle
        int[][] edges4 = {{1,2},{2,3},{3,4},{4,5},{1,5}};
        int[] result4 = solution.findRedundantConnection(edges4);
        assertTrue(Arrays.equals(new int[]{1,5}, result4));
        
        // Test case 5: Larger graph
        int[][] edges5 = {{1,2},{1,3},{1,4},{2,4}};
        int[] result5 = solution.findRedundantConnection(edges5);
        assertTrue(Arrays.equals(new int[]{2,4}, result5));
        
        // Test case 6: Sequential connections with cycle
        int[][] edges6 = {{2,3},{5,2},{1,5},{4,1},{4,3}};
        int[] result6 = solution.findRedundantConnection(edges6);
        assertTrue(Arrays.equals(new int[]{4,3}, result6));
    }
}