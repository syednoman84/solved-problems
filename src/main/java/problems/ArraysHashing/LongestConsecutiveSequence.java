package problems.ArraysHashing;

/*
 * 128. Longest Consecutive Sequence
 * Medium
 * 
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * 
 * You must write an algorithm that runs in O(n) time.
 * 
 * Example 1:
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * 
 * Example 2:
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 * 
 * Constraints:
 * - 0 <= nums.length <= 10^5
 * - -10^9 <= nums[i] <= 10^9
 */

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int result = 0;
        for(int num : nums)
            set.add(num);
        int count = 0;
        for(int num : nums) {
            if(!set.contains(num-1)) {
                while(set.contains(num++))
                    count++;
                result = Math.max(result, count);
                count = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence solution = new LongestConsecutiveSequence();
        
        // Test case 1
        int[] nums1 = {100,4,200,1,3,2};
        int result1 = solution.longestConsecutive(nums1);
        int expected1 = 4;
        String status1 = result1 == expected1 ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: " + expected1 + ", Got: " + result1 + " [" + status1 + "]");
        
        // Test case 2
        int[] nums2 = {0,3,7,2,5,8,4,6,0,1};
        int result2 = solution.longestConsecutive(nums2);
        int expected2 = 9;
        String status2 = result2 == expected2 ? "PASS" : "FAIL";
        System.out.println("Test 2 - Expected: " + expected2 + ", Got: " + result2 + " [" + status2 + "]");
    }
}
