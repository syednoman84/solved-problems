package problems.BitManipulation;

/**
 * [338. Counting Bits](https://leetcode.com/problems/counting-bits/)
 * Easy
 *
 * Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n),
 * ans[i] is the number of 1's in the binary representation of i.
 *
 * Example 1:
 * Input: n = 2
 * Output: [0,1,1]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 *
 * Example 2:
 * Input: n = 5
 * Output: [0,1,1,2,1,2]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 *
 * Constraints:
 * - 0 <= n <= 10^5
 *
 * Approach:
 * - Use dynamic programming with the pattern: dp[i] = dp[i/2] + i % 2
 * - This works because:
 *   - i/2 removes the last bit
 *   - i % 2 gives the last bit
 *   - So the number of 1s in i = number of 1s in i/2 + the last bit of i
 *
 * Complexity Analysis:
 * - Time Complexity: O(n)
 * - Space Complexity: O(n)
 */
public class CountingBits {
    public int[] countBits(int n) {
        int[] dp = new int[n+1];
        
        for(int i = 1; i < n+1; i++) {
            dp[i] = dp[i/2] + i % 2;
        }
        
        return dp;
    }

    public static void main(String[] args) {
        CountingBits solution = new CountingBits();
        
        // Test case 1
        int n = 2;
        int[] result = solution.countBits(n);
        int[] expected = {0, 1, 1};
        boolean status = java.util.Arrays.equals(result, expected);
        System.out.println("Test 1 - Expected: " + java.util.Arrays.toString(expected) + ", Got: " + java.util.Arrays.toString(result) + " [" + (status ? "PASS" : "FAIL") + "]");
    }
}
