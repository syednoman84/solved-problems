package problems.Graphs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GraphValidTreeTest {

    @Test
    void testValidTree() {
        GraphValidTree solution = new GraphValidTree();
        
        // Test case 1: Valid tree
        int n1 = 5;
        int[][] edges1 = {{0,1},{0,2},{0,3},{1,4}};
        assertTrue(solution.validTree(n1, edges1));
        
        // Test case 2: Graph with cycle
        int n2 = 5;
        int[][] edges2 = {{0,1},{1,2},{2,3},{1,3},{1,4}};
        assertFalse(solution.validTree(n2, edges2));
        
        // Test case 3: Single node
        int n3 = 1;
        int[][] edges3 = {};
        assertTrue(solution.validTree(n3, edges3));
        
        // Test case 4: Two nodes connected
        int n4 = 2;
        int[][] edges4 = {{0,1}};
        assertTrue(solution.validTree(n4, edges4));
        
        // Test case 5: Two nodes not connected
        int n5 = 2;
        int[][] edges5 = {};
        assertFalse(solution.validTree(n5, edges5));
        
        // Test case 6: Disconnected components
        int n6 = 4;
        int[][] edges6 = {{0,1},{2,3}};
        assertFalse(solution.validTree(n6, edges6));
        
        // Test case 7: Too many edges
        int n7 = 3;
        int[][] edges7 = {{0,1},{1,2},{0,2},{1,0}};
        assertFalse(solution.validTree(n7, edges7));
        
        // Test case 8: Linear tree
        int n8 = 4;
        int[][] edges8 = {{0,1},{1,2},{2,3}};
        assertTrue(solution.validTree(n8, edges8));
        
        // Test case 9: Empty graph
        int n9 = 0;
        int[][] edges9 = {};
        assertFalse(solution.validTree(n9, edges9));
    }
}