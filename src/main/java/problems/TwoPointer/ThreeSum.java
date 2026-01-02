package problems.TwoPointer;

/*
 * 15. 3Sum
 * Medium
 * 
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] 
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * 
 * Notice that the solution set must not contain duplicate triplets.
 * 
 * Example 1:
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * 
 * Example 2:
 * Input: nums = []
 * Output: []
 * 
 * Example 3:
 * Input: nums = [0]
 * Output: []
 * 
 * Constraints:
 * - 0 <= nums.length <= 3000
 * - -10^5 <= nums[i] <= 10^5
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2; i++) {
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            search(i, nums, result);
        }
        return result;
    }
    
    private void search(int index, int[] nums, List<List<Integer>> result) {
        int left = index+1, right = nums.length-1;
        while(left < right) {
            int sum = nums[index] + nums[left] + nums[right];
            if(sum == 0) {
                result.add(Arrays.asList(nums[index], nums[left], nums[right]));
                left++;
                right--;
                while(left < right && nums[left]==nums[left-1])
                    left++;
                while(left < right && nums[right]==nums[right+1])
                    right--;
            } else if(sum < 0) {
                left++;
            } else {
                right--;
            }
        }
    }

    public static void main(String[] args) {
        ThreeSum solution = new ThreeSum();
        
        // Test case 1: nums = []
        List<List<Integer>> result1 = solution.threeSum(new int[]{});
        boolean expected1 = true;
        boolean actual1 = result1.isEmpty();
        String status1 = actual1 == expected1 ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: " + expected1 + ", Got: " + actual1 + " [" + status1 + "]");
    }
}
