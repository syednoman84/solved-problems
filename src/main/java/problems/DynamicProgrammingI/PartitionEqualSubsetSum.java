package problems.DynamicProgrammingI;

/**
 * [416. Partition Equal Subset Sum](https://leetcode.com/problems/partition-equal-subset-sum/)
 * Medium
 *
 * Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets
 * such that the sum of elements in both subsets is equal.
 *
 * Example 1:
 * Input: nums = [1,5,11,5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 *
 * Example 2:
 * Input: nums = [1,2,3,5]
 * Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 *
 * Constraints:
 * - 1 <= nums.length <= 200
 * - 1 <= nums[i] <= 100
 *
 * Approach:
 * - sum of all the elements, if it's odd return false
 * - otherwise, find whther there is a subset such that it's equal to sum/2
 *
 * Complexity Analysis:
 * - Time Complexity: O(N*Sum)
 * - Space Complexity: O(N*Sum)
 */
public class PartitionEqualSubsetSum {
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        if(sum%2 != 0)
            return false;
        dp = new Boolean[nums.length][sum/2+1];
        return subsetSum(nums, 0, sum/2);
    }
    
    // DP
    private boolean subsetSum(int[] nums, int ind, int sum) {
        if(ind >= nums.length || sum < 0)
            return false;
        if(sum == 0)
            return true;
        if(dp[ind][sum] != null)
            return dp[ind][sum];
        dp[ind][sum]  = subsetSum(nums, ind+1, sum-nums[ind]) || subsetSum(nums, ind+1, sum);
        return dp[ind][sum];
    }

    public static void main(String[] args) {
        PartitionEqualSubsetSum solution = new PartitionEqualSubsetSum();
        
        // Test case 1
        int[] nums = {1, 5, 11, 5};
        boolean result = solution.canPartition(nums);
        boolean expected = true;
        String status = result == expected ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: " + expected + ", Got: " + result + " [" + status + "]");
    }
}
