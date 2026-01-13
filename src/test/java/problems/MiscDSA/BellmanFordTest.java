package problems.MiscDSA;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BellmanFordTest {

    @Test
    void testBellmanFord() {
        BellmanFord.Edge[] edges = {
            new BellmanFord.Edge(0, 1, 4),
            new BellmanFord.Edge(0, 2, 2),
            new BellmanFord.Edge(1, 2, -3)
        };
        double[] result = BellmanFord.bellmanFord(edges, 3, 0);
        assertEquals(0.0, result[0], 0.001);
        assertEquals(4.0, result[1], 0.001);
        assertEquals(1.0, result[2], 0.001);
    }
}