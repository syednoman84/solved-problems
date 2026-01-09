package problems.Graphs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

class CloneGraphTest {

    @Test
    void testCloneGraph() {
        CloneGraph solution = new CloneGraph();
        
        // Test case 1: Null graph
        assertNull(solution.cloneGraph(null));
        
        // Test case 2: Single node with no neighbors
        CloneGraph.Node node1 = solution.new Node(1);
        CloneGraph.Node cloned1 = solution.cloneGraph(node1);
        assertNotNull(cloned1);
        assertEquals(1, cloned1.val);
        assertEquals(0, cloned1.neighbors.size());
        assertNotSame(node1, cloned1);
        
        // Test case 3: Two connected nodes
        CloneGraph.Node node2 = solution.new Node(1);
        CloneGraph.Node node3 = solution.new Node(2);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        
        CloneGraph.Node cloned2 = solution.cloneGraph(node2);
        assertNotNull(cloned2);
        assertEquals(1, cloned2.val);
        assertEquals(1, cloned2.neighbors.size());
        assertEquals(2, cloned2.neighbors.get(0).val);
        assertNotSame(node2, cloned2);
        assertNotSame(node3, cloned2.neighbors.get(0));
        
        // Test case 4: Four node cycle
        CloneGraph.Node n1 = solution.new Node(1);
        CloneGraph.Node n2 = solution.new Node(2);
        CloneGraph.Node n3 = solution.new Node(3);
        CloneGraph.Node n4 = solution.new Node(4);
        
        n1.neighbors.add(n2);
        n1.neighbors.add(n4);
        n2.neighbors.add(n1);
        n2.neighbors.add(n3);
        n3.neighbors.add(n2);
        n3.neighbors.add(n4);
        n4.neighbors.add(n1);
        n4.neighbors.add(n3);
        
        CloneGraph.Node cloned = solution.cloneGraph(n1);
        assertNotNull(cloned);
        assertEquals(1, cloned.val);
        assertEquals(2, cloned.neighbors.size());
        
        // Verify structure integrity
        boolean hasNode2 = false, hasNode4 = false;
        for (CloneGraph.Node neighbor : cloned.neighbors) {
            if (neighbor.val == 2) hasNode2 = true;
            if (neighbor.val == 4) hasNode4 = true;
        }
        assertTrue(hasNode2 && hasNode4);
    }
}