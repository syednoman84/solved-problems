package problems.DynamicProgrammingI;

/**
 * [70. Climbing Stairs](https://leetcode.com/problems/climbing-stairs/)
 * Easy
 *
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Example 1:
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 *
 * Example 2:
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 * Constraints:
 * - 1 <= n <= 45
 *
 * Approach:
 * - Problem effectively becomes fibonacci
 *
 * Complexity Analysis:
 * - Time Complexity: O(N)
 * - Space Complexity: O(1)
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        int one = 1, two = 1;
        for(int i = 2; i <= n; i++) {
            int tmp = one;
            one = one + two;
            two = tmp;
        }
        return one;
    }

    public static void main(String[] args) {
        ClimbingStairs solution = new ClimbingStairs();
        
        // Test case 1
        int n = 2;
        int result = solution.climbStairs(n);
        int expected = 2;
        String status = result == expected ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: " + expected + ", Got: " + result + " [" + status + "]");
    }
}
