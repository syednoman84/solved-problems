/*
 * 238. Product of Array Except Self
 * Medium
 * 
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product 
 * of all the elements of nums except nums[i].
 * 
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * 
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 * 
 * Example 1:
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * 
 * Example 2:
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 * 
 * Constraints:
 * - 2 <= nums.length <= 10^5
 * - -30 <= nums[i] <= 30
 * - The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * 
 * Follow up: Can you solve the problem in O(1) extra space complexity? 
 * (The output array does not count as extra space for space complexity analysis.)
 */

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int pre = 1;
        res[0] = 1;
        for(int i = 0; i < n-1; i++) {
            pre *= nums[i];
            res[i+1] = pre;
        }
        int post = 1;
        for(int i = n-1; i > 0; i--) {
            post *= nums[i];
            res[i-1] *= post;
        }
        return res;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf solution = new ProductOfArrayExceptSelf();
        
        // Test case 1
        int[] nums1 = {1,2,3,4};
        int[] result1 = solution.productExceptSelf(nums1);
        int[] expected1 = {24,12,8,6};
        boolean match1 = Arrays.equals(result1, expected1);
        String status1 = match1 ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: " + Arrays.toString(expected1) + ", Got: " + Arrays.toString(result1) + " [" + status1 + "]");
        
        // Test case 2
        int[] nums2 = {-1,1,0,-3,3};
        int[] result2 = solution.productExceptSelf(nums2);
        int[] expected2 = {0,0,9,0,0};
        boolean match2 = Arrays.equals(result2, expected2);
        String status2 = match2 ? "PASS" : "FAIL";
        System.out.println("Test 2 - Expected: " + Arrays.toString(expected2) + ", Got: " + Arrays.toString(result2) + " [" + status2 + "]");
    }
}
