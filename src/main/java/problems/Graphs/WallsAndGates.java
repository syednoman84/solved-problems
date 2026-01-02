import java.util.LinkedList;
import java.util.Queue;

/**
 * 663 · Walls and Gates
 * Medium
 *
 * You are given a m x n 2D grid initialized with these three possible values.
 * -1 : A wall or an obstacle.
 * 0 : A gate.
 * INF - Infinity means an empty room. We use the value 2^31 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
 *
 * Fill each empty room with the distance to its nearest gate. If it is impossible to reach a Gate, that room should remain filled with INF
 *
 * Example 1:
 * Input: [[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1],[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]]
 * Output: [[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]]
 *
 * Example 2:
 * Input: [[0,-1],[2147483647,2147483647]]
 * Output: [[0,-1],[1,2]]
 *
 * Approach:
 * - BFS or Topological Sort
 * - Start from the grid having 0 (add them to a queue)
 * - while queue is not empty:
 *   - if neighbour of current position is INF, change it to 1+val coming from the queue and add it to queue
 *   - otherwise take min of neighour's value and 1+val
 *
 * Complexity Analysis:
 * - Time Complexity: O(k*n*m)
 * - Space Complexity: O(n*m)
 */
public class WallsAndGates {
    public void islandsAndTreasure(int[][] grid) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1} };
        Queue<int[]> q = new LinkedList<>();
        int n = grid.length, m = grid[0].length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 0)
                    q.offer(new int[]{i, j});
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] currPos = q.poll();
                int currI = currPos[0], currJ = currPos[1];
                int val = grid[currI][currJ];
                for (int[] dir : dirs) {
                    if (currI + dir[0] < 0 || currJ + dir[1] < 0 || currI + dir[0] >= n || currJ + dir[1] >= m
                            || grid[currI + dir[0]][currJ + dir[1]] == -1)
                        continue;
                    else if (grid[currI + dir[0]][currJ + dir[1]] == 2147483647) {
                        grid[currI + dir[0]][currJ + dir[1]] = 1 + val;
                        q.offer(new int[] { currI + dir[0], currJ + dir[1] });
                    } else {
                        grid[currI + dir[0]][currJ + dir[1]] = Math.min(grid[currI + dir[0]][currJ + dir[1]], 1 + val);
                    }
                }

            }
        }
    }

    public static void main(String[] args) {
        WallsAndGates solution = new WallsAndGates();
        
        // Test case 1
        int[][] grid = {{2147483647, -1, 0, 2147483647}, {2147483647, 2147483647, 2147483647, -1}, {2147483647, -1, 2147483647, -1}, {0, -1, 2147483647, 2147483647}};
        solution.islandsAndTreasure(grid);
        boolean expected = grid[0][0] == 3 && grid[1][0] == 2;
        String status = expected ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: true, Got: " + expected + " [" + status + "]");
    }
}
