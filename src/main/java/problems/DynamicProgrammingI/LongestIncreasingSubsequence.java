package problems.DynamicProgrammingI;

/**
 * [300. Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence/)
 * Medium
 *
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 * A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements.
 * For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 *
 * Example 1:
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 *
 * Example 2:
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 *
 * Example 3:
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 *
 * Constraints:
 * - 1 <= nums.length <= 2500
 * - -10^4 <= nums[i] <= 10^4
 *
 * Approach:
 * - Starting from 2nd last element, lis[] will store 1 for all the elements
 * - compare it with the next element, if the next element is less than current element
 *   - add max of lis[curr], 1+lis[next]
 *
 * Complexity Analysis:
 * - Time Complexity: O(n^2)
 * - Space Complexity: O(n)
 */
import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] lis = new int[n];
        Arrays.fill(lis, 1);
        lis[n-1] = 1;
        int res = 1;
        for(int i = n-2; i >= 0; i--) {
            for(int j = i+1; j < n; j++) {
                if(nums[i] < nums[j])
                    lis[i] = Math.max(lis[i], 1+lis[j]);
            } 
            res = Math.max(res, lis[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence solution = new LongestIncreasingSubsequence();
        
        // Test case 1
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int result = solution.lengthOfLIS(nums);
        int expected = 4;
        String status = result == expected ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: " + expected + ", Got: " + result + " [" + status + "]");
    }
}
