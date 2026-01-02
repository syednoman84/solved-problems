import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * [133. Clone Graph](https://leetcode.com/problems/clone-graph/)
 * Medium
 *
 * Given a reference of a node in a connected undirected graph.
 * Return a deep copy (clone) of the graph.
 * Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
 *
 * Example 1:
 * Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
 * Output: [[2,4],[1,3],[2,4],[1,3]]
 *
 * Example 2:
 * Input: adjList = [[]]
 * Output: [[]]
 *
 * Example 3:
 * Input: adjList = []
 * Output: []
 *
 * Constraints:
 * - The number of nodes in the graph is in the range [0, 100].
 * - 1 <= Node.val <= 100
 * - Node.val is unique for each node.
 * - There are no repeated edges and no self-loops in the graph.
 * - The Graph is connected and all nodes can be visited starting from the given node.
 *
 * Complexity Analysis:
 * - Time Complexity: O(n*m)
 * - Space Complexity: O(n+m)
 */
public class CloneGraph {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Integer, Node> mp = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        Set<Node> set = new HashSet<>();
        q.offer(node);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            set.add(curr);

            List<Node> nei = curr.neighbors;
            ArrayList<Node> newNei = new ArrayList<>();
            for (Node n : nei) {
                if (!set.contains(n)) q.offer(n);
                if (!mp.containsKey(n.val)) {
                    Node newN = new Node(n.val);
                    mp.put(newN.val, newN);
                    newNei.add(newN);
                } else {
                    Node newN = mp.get(n.val);
                    newNei.add(newN);
                }
            }
            if (!mp.containsKey(curr.val)) {
                Node newNode = new Node(curr.val, newNei);
                mp.put(curr.val, newNode);
            } else {
                Node newNode = mp.get(curr.val);
                newNode.neighbors = newNei;
                mp.put(curr.val, newNode);
            }
        }

        return mp.get(node.val);
    }

    public static void main(String[] args) {
        CloneGraph solution = new CloneGraph();
        
        // Test case 1: Single node with no neighbors
        Node node = solution.new Node(1);
        Node result = solution.cloneGraph(node);
        boolean expected = result != null && result.val == 1 && result.neighbors.size() == 0;
        String status = expected ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: true, Got: " + expected + " [" + status + "]");
    }

    public class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
