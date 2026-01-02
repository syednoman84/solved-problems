package problems.AdvancedGraphs;

import java.util.Arrays;

/**
 * [787. Cheapest Flights Within K Stops](https://leetcode.com/problems/cheapest-flights-within-k-stops/)
 * Medium
 *
 * There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.
 * You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.
 *
 * Example 1:
 * Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
 * Output: 700
 *
 * Example 2:
 * Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
 * Output: 200
 *
 * Example 3:
 * Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
 * Output: 500
 *
 * Constraints:
 * - 1 <= n <= 100
 * - 0 <= flights.length <= (n * (n - 1) / 2)
 * - flights[i].length == 3
 * - 0 <= fromi, toi < n
 * - fromi != toi
 * - 1 <= pricei <= 10^4
 * - There will not be any multiple flights between two cities.
 * - 0 <= src, dst, k < n
 * - src != dst
 *
 * Approach:
 * Bellman Ford Algorithm
 * - It runs for n * E time, n : number of nodes & E : edges
 * - here modified to run for k+1 times
 *
 * Complexity Analysis:
 * - Time Complexity: O(k*E), E size of flights array
 * - Space Complexity: O(n)
 */
public class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;
        
        for(int i = 0; i <= k; i++) {
            int[] tmp = new int[n];
            Arrays.fill(tmp, Integer.MAX_VALUE);
            for(int[] flight : flights) {
                if(cost[flight[0]] != Integer.MAX_VALUE) {
                    int newCost = cost[flight[0]] + flight[2];
                    if(newCost < tmp[flight[1]])
                        tmp[flight[1]] = newCost;
                }
            }
            // Merge tmp with cost (keep the minimum)
            for(int j = 0; j < n; j++) {
                cost[j] = Math.min(cost[j], tmp[j]);
            }
        }
        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }

    public static void main(String[] args) {
        CheapestFlightsWithinKStops solution = new CheapestFlightsWithinKStops();
        
        // Test case 1
        int n = 4;
        int[][] flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src = 0, dst = 3, k = 1;
        int result = solution.findCheapestPrice(n, flights, src, dst, k);
        int expected = 700;
        String status = result == expected ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: " + expected + ", Got: " + result + " [" + status + "]");
    }
}
