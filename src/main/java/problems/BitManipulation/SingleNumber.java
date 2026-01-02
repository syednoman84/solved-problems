/**
 * [136. Single Number](https://leetcode.com/problems/single-number/)
 * Easy
 *
 * Given a non-empty array of integers nums, every element appears twice except for one.
 * Find that single one.
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 *
 * Example 1:
 * Input: nums = [2,2,1]
 * Output: 1
 *
 * Example 2:
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 *
 * Example 3:
 * Input: nums = [1]
 * Output: 1
 *
 * Constraints:
 * - 1 <= nums.length <= 3 * 10^4
 * - -3 * 10^4 <= nums[i] <= 3 * 10^4
 * - Each element in the array appears twice except for one element which appears only once.
 *
 * Approach:
 * - Use XOR operation: a ^ a = 0 and a ^ 0 = a
 * - XOR all elements, the duplicates will cancel out, leaving only the single number
 *
 * Complexity Analysis:
 * - Time Complexity: O(n)
 * - Space Complexity: O(1)
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int res = 0;
        
        for(int num : nums) {
            res ^= num;
        }
        
        return res;
    }

    public static void main(String[] args) {
        SingleNumber solution = new SingleNumber();
        
        // Test case 1
        int[] nums = {2, 2, 1};
        int result = solution.singleNumber(nums);
        int expected = 1;
        String status = result == expected ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: " + expected + ", Got: " + result + " [" + status + "]");
    }
}
