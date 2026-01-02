/**
 * [53. Maximum Subarray](https://leetcode.com/problems/maximum-subarray/)
 * Easy
 *
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * A subarray is a contiguous part of an array.
 *
 * Example 1:
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 * Example 2:
 * Input: nums = [1]
 * Output: 1
 *
 * Example 3:
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 *
 * Constraints:
 * - 1 <= nums.length <= 10^5
 * - -10^4 <= nums[i] <= 10^4
 *
 * Approach:
 * - Kadane's Algorithm
 * - Keep track of the maximum sum ending at the current position
 * - If the sum becomes negative, reset it to 0
 * - Keep track of the overall maximum sum
 *
 * Complexity Analysis:
 * - Time Complexity: O(N)
 * - Space Complexity: O(1)
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        
        int total = 0;
        int result = nums[0];
        
        for(int num : nums) {
            if(total < 0)
                total = 0;
            total = total+num;
            result = Math.max(result, total);
        }
        
        return result;
    }

    public static void main(String[] args) {
        MaximumSubarray solution = new MaximumSubarray();
        
        // Test case 1
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = solution.maxSubArray(nums);
        int expected = 6;
        String status = result == expected ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: " + expected + ", Got: " + result + " [" + status + "]");
    }
}
