package problems.ArraysHashing;

/*
 * 217. Contains Duplicate
 * Easy
 * 
 * Given an integer array nums, return true if any value appears at least twice in the array, 
 * and return false if every element is distinct.
 * 
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: true
 * 
 * Example 2:
 * Input: nums = [1,2,3,4]
 * Output: false
 * 
 * Example 3:
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 * 
 * Constraints:
 * - 1 <= nums.length <= 10^5
 * - -10^9 <= nums[i] <= 10^9
 */

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            if(!set.add(num))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate solution = new ContainsDuplicate();
        
        // Test case 1
        int[] nums1 = {1,2,3,1};
        boolean result1 = solution.containsDuplicate(nums1);
        boolean expected1 = true;
        String status1 = result1 == expected1 ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: " + expected1 + ", Got: " + result1 + " [" + status1 + "]");
        
        // Test case 2
        int[] nums2 = {1,2,3,4};
        boolean result2 = solution.containsDuplicate(nums2);
        boolean expected2 = false;
        String status2 = result2 == expected2 ? "PASS" : "FAIL";
        System.out.println("Test 2 - Expected: " + expected2 + ", Got: " + result2 + " [" + status2 + "]");
    }
}
