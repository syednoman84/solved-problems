/*
 * 1. Two Sum
 * Easy
 * 
 * Given an array of integers nums and an integer target, return indices of the two numbers 
 * such that they add up to target.
 * 
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * 
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * 
 * Example 2:
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * 
 * Example 3:
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 * 
 * Constraints:
 * - 2 <= nums.length <= 10^4
 * - -10^9 <= nums[i] <= 10^9
 * - -10^9 <= target <= 10^9
 * - Only one valid answer exists.
 * 
 * Follow-up: Can you come up with an algorithm that is less than O(n^2) time complexity?
 */

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < n; i++) {
            int remaining = target-nums[i];
            if(map.containsKey(remaining)) {
                return new int[] {map.get(remaining), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        TwoSum solution = new TwoSum();
        
        // Test case 1
        int[] nums1 = {2,7,11,15};
        int target1 = 9;
        int[] result1 = solution.twoSum(nums1, target1);
        int[] expected1 = {0,1};
        boolean match1 = java.util.Arrays.equals(result1, expected1);
        String status1 = match1 ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: " + java.util.Arrays.toString(expected1) + ", Got: " + java.util.Arrays.toString(result1) + " [" + status1 + "]");
        
        // Test case 2
        int[] nums2 = {3,2,4};
        int target2 = 6;
        int[] result2 = solution.twoSum(nums2, target2);
        int[] expected2 = {1,2};
        boolean match2 = java.util.Arrays.equals(result2, expected2);
        String status2 = match2 ? "PASS" : "FAIL";
        System.out.println("Test 2 - Expected: " + java.util.Arrays.toString(expected2) + ", Got: " + java.util.Arrays.toString(result2) + " [" + status2 + "]");
    }
}
