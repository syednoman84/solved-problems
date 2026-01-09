package problems.HeapPriorityQueue;

import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    /**
     * 973. K Closest Points to Origin
     * Medium
     * 
     * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).
     * 
     * The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
     * 
     * You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
     * 
     * Example 1:
     * Input: points = [[1,3],[-2,2]], k = 1
     * Output: [[-2,2]]
     * Explanation: The distance between (1, 3) and the origin is sqrt(10).
     * The distance between (-2, 2) and the origin is sqrt(8).
     * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
     * We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
     * 
     * Example 2:
     * Input: points = [[3,3],[5,-1],[-2,4]], k = 2
     * Output: [[3,3],[-2,4]]
     * Explanation: The answer [[-2,4],[3,3]] would also be accepted.
     * 
     * Constraints:
     * - 1 <= k <= points.length <= 10^4
     * - -10^4 < xi, yi < 10^4
     * 
     * Approach:
     * - Have a Max PriorityQueue based on euclidean distance
     * - add each point to PQ, if size > k then poll
     * - remaining points inside the PQ is the answer
     * 
     * Time Complexity: O(nlogk)
     * Space Complexity: O(k)
     */
    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1]));
        
        for(int[] point: points) {
            pq.offer(point);
            if(pq.size() > k)
                pq.poll();
        }
        int ind = 0;
        while(!pq.isEmpty()) {
            int[] p = pq.poll();
            res[ind][0] = p[0];
            res[ind][1] = p[1];
            ind++;
        }
        return res;
    }

    public static void main(String[] args) {
        KClosestPointsToOrigin solution = new KClosestPointsToOrigin();
        
        // Test case 1
        int[][] points = {{1, 3}, {-2, 2}};
        int k = 1;
        int[][] result = solution.kClosest(points, k);
        boolean expected = result.length == 1 && result[0][0] == -2 && result[0][1] == 2;
        String status = expected ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: true, Got: " + expected + " [" + status + "]");
    }
}
