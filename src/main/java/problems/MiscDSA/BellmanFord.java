package problems.MiscDSA;

/**
 * Bellman-Ford Algorithm for Single Source Shortest Path
 *
 * The Bellman-Ford algorithm finds the shortest path from a source node to all other nodes.
 * Unlike Dijkstra's algorithm, it can handle negative edge weights and detect negative cycles.
 *
 * Approach:
 * - Relax all edges V-1 times
 * - Run one more iteration to detect negative cycles
 * - If a node is part of a negative cycle, mark its distance as NEGATIVE_INFINITY
 *
 * Complexity Analysis:
 * - Time Complexity: O(V * E)
 * - Space Complexity: O(V)
 */
import java.util.Arrays;

public class BellmanFord {
    
    /**
     * Edge class to represent a directed edge
     */
    public static class Edge {
        double cost;
        int from, to;

        public Edge(int from, int to, double cost) {
            this.to = to;
            this.from = from;
            this.cost = cost;
        }
    }

    /**
     * Bellman-Ford algorithm implementation
     * Finds shortest path from start node to all other nodes
     * Detects negative cycles and marks affected nodes with NEGATIVE_INFINITY
     */
    public static double[] bellmanFord(Edge[] edges, int V, int start) {
        double[] dist = new double[V];
        Arrays.fill(dist, Double.POSITIVE_INFINITY);
        dist[start] = 0;

        // Relax edges V-1 times
        boolean relaxedAnEdge = true;
        for (int v = 0; v < V - 1 && relaxedAnEdge; v++) {
            relaxedAnEdge = false;
            for (Edge edge : edges) {
                if (dist[edge.from] + edge.cost < dist[edge.to]) {
                    dist[edge.to] = dist[edge.from] + edge.cost;
                    relaxedAnEdge = true;
                }
            }
        }

        // Detect negative cycles
        relaxedAnEdge = true;
        for (int v = 0; v < V - 1 && relaxedAnEdge; v++) {
            relaxedAnEdge = false;
            for (Edge edge : edges) {
                if (dist[edge.from] + edge.cost < dist[edge.to]) {
                    dist[edge.to] = Double.NEGATIVE_INFINITY;
                    relaxedAnEdge = true;
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        // Test case 1: Simple graph with 3 vertices
        Edge[] edges = {
            new Edge(0, 1, 4),
            new Edge(0, 2, 2),
            new Edge(1, 2, 1)
        };
        double[] result = bellmanFord(edges, 3, 0);
        boolean expected = true;
        boolean actual = result[0] == 0 && result[1] == 3 && result[2] == 2;
        String status = actual == expected ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: " + expected + ", Got: " + actual + " [" + status + "]");
    }
}
