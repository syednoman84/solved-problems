package problems.Graphs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NumberOfConnectedComponentsInAnUndirectedGraphTest {

    @Test
    void testCountComponents() {
        NumberOfConnectedComponentsInAnUndirectedGraph solution = new NumberOfConnectedComponentsInAnUndirectedGraph();
        
        // Test case 1: Two components
        int n1 = 5;
        int[][] edges1 = {{0,1},{1,2},{3,4}};
        assertEquals(2, solution.countComponents(n1, edges1));
        
        // Test case 2: Single component
        int n2 = 5;
        int[][] edges2 = {{0,1},{1,2},{2,3},{3,4}};
        assertEquals(1, solution.countComponents(n2, edges2));
        
        // Test case 3: All isolated nodes
        int n3 = 3;
        int[][] edges3 = {};
        assertEquals(3, solution.countComponents(n3, edges3));
        
        // Test case 4: Single node
        int n4 = 1;
        int[][] edges4 = {};
        assertEquals(1, solution.countComponents(n4, edges4));
        
        // Test case 5: Two nodes connected
        int n5 = 2;
        int[][] edges5 = {{0,1}};
        assertEquals(1, solution.countComponents(n5, edges5));
        
        // Test case 6: Complex graph with multiple components
        int n6 = 6;
        int[][] edges6 = {{0,1},{2,3},{4,5}};
        assertEquals(3, solution.countComponents(n6, edges6));
        
        // Test case 7: Star graph
        int n7 = 5;
        int[][] edges7 = {{0,1},{0,2},{0,3},{0,4}};
        assertEquals(1, solution.countComponents(n7, edges7));
        
        // Test case 8: Linear chain
        int n8 = 4;
        int[][] edges8 = {{0,1},{1,2},{2,3}};
        assertEquals(1, solution.countComponents(n8, edges8));
        
        // Test case 9: Mixed components
        int n9 = 7;
        int[][] edges9 = {{0,1},{1,2},{3,4},{5,6}};
        assertEquals(3, solution.countComponents(n9, edges9));
    }
}