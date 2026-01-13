package problems.MiscDSA;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BFSGraphTest {

    @Test
    void testBFSGraph() {
        BFSGraph.Graph g = new BFSGraph.Graph(4, false);
        g.insertEdge(0, 1, false);
        g.insertEdge(1, 2, false);
        g.insertEdge(2, 3, false);
        
        BFSGraph bfs = new BFSGraph(g);
        assertNotNull(bfs.discovered);
        assertNotNull(bfs.processed);
        assertEquals(4, bfs.discovered.length);
        assertEquals(4, bfs.processed.length);
    }
}