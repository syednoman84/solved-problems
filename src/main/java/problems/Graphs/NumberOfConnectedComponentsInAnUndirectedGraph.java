import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * [323. Number of Connected Components in an Undirected Graph](https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/)
 * Medium
 *
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.
 *
 * Example 1:
 * Input: n = 5 and edges = [[0, 1], [1, 2], [3, 4]]
 * Output: 2
 *
 * Example 2:
 * Input: n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]]
 * Output: 1
 *
 * Note: You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 *
 * Approach:
 * 1. DFS
 *   - Number of times dfs called is equal to the number of components
 * 2. Union Find
 *   - Take number of nodes as the number of components initially
 *   - if the nodes of an edge are not already connected then decrease the count and union the nodes
 *
 * Complexity Analysis:
 * - Time Complexity: O(n)
 * - Space Complexity: O(n+m)
 */
public class NumberOfConnectedComponentsInAnUndirectedGraph {
    public int countComponents(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        boolean[] visited = new boolean[n];

        int count = 0;
        // Step - 1 Build the graph
        for(int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++){
            // Make Undirected Graph
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        // Step -2 run algorithm
        for (int i = 0; i < n; i++) {
            if(!visited[i]) {
                count++;
                dfs(i, graph, visited);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOfConnectedComponentsInAnUndirectedGraph solution = new NumberOfConnectedComponentsInAnUndirectedGraph();
        
        // Test case 1
        int n = 5;
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        int result = solution.countComponents(n, edges);
        int expected = 2;
        String status = result == expected ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: " + expected + ", Got: " + result + " [" + status + "]");
    }

    private void dfs(int at, HashMap<Integer, List<Integer>> graph, boolean[] visited) {
        visited[at] = true;
        for(Integer child: graph.get(at)) {
            if(!visited[child]) {
                dfs(child, graph, visited);
            }
        }
    }
}
