package problems.MiscDSA;

/**
 * Breadth-First Search (BFS) on Graph
 *
 * BFS is a graph traversal algorithm that explores vertices in layers.
 * It visits all vertices at distance k before visiting vertices at distance k+1.
 *
 * Vertex States:
 * - Undiscovered: Initial state
 * - Discovered: Found but not all incident edges checked
 * - Processed: All incident edges have been visited
 *
 * Complexity Analysis:
 * - Time Complexity: O(V + E)
 * - Space Complexity: O(V)
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BFSGraph {
    boolean[] processed;
    boolean[] discovered;
    int[] parent;
    Graph g;

    public BFSGraph(Graph g) {
        this.g = g;
        processed = new boolean[g.nvertices];
        discovered = new boolean[g.nvertices];
        parent = new int[g.nvertices];
        for(int i = 0; i < g.nvertices; i++)
            parent[i] = -1;
    }

    /**
     * Perform BFS starting from a given vertex
     */
    public void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        int v;
        int y;

        q.offer(start);
        discovered[start] = true;

        while (!q.isEmpty()) {
            v = q.poll();
            System.out.println(v);
            processed[v] = true;
            List<int[]> neighbors = g.adjList.get(v);
            for(int[] neighbor : neighbors) {
                y = neighbor[0];
                if(!processed[y] || g.directed) {
                    System.out.println(v+"-"+y);
                }
                if(!discovered[y]) {
                    q.offer(y);
                    discovered[y] = true;
                    parent[y] = v;
                }
            }
        }
    }

    /**
     * Find and print path from start to end
     */
    public void findPath(int start, int end) {
        if(start == end || (end == -1))
            System.out.println(start);
        else {
            findPath(start, parent[end]);
            System.out.println(end);
        }
    }

    /**
     * Graph class to represent adjacency list
     */
    public static class Graph {
        public Map<Integer, List<int[]>> adjList;
        public int nvertices;
        public int nedges;
        public int[] degree;
        public boolean directed;

        public Graph(int v) {
            degree = new int[v];
            nvertices = v;
            nedges = 0;
            adjList = new HashMap<>();
            for(int i = 0; i < v; i++) {
                adjList.put(i, new ArrayList<>());
            }
        }

        public Graph(int v, boolean directed) {
            this(v);
            if(directed)
                this.directed = true;
        }

        public void insertEdge(int x, int y, int weight, boolean directed) {
            List<int[]> list = adjList.get(x);
            int[] tmp = new int[2];
            tmp[0] = y;
            tmp[1] = weight;
            list.add(tmp);
            adjList.put(x, list);
            if(!directed) {
                List<int[]> list2 = adjList.get(y);
                int[] tmp2 = new int[2];
                tmp2[0] = x;
                tmp2[1] = weight;
                list2.add(tmp2);
                adjList.put(y, list2);
            }
        }

        public void insertEdge(int x, int y, boolean directed) {
            insertEdge(x, y, 0, directed);
        }
    }

    public static void main(String[] args) {
        // Test case 1: Simple graph with 3 vertices
        Graph g = new Graph(3, false);
        g.insertEdge(0, 1, false);
        g.insertEdge(1, 2, false);
        BFSGraph bfs = new BFSGraph(g);
        
        boolean expected = true;
        boolean actual = bfs.discovered != null && bfs.processed != null;
        String status = actual == expected ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: " + expected + ", Got: " + actual + " [" + status + "]");
    }
}
