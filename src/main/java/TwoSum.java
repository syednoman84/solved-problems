import java.util.HashMap;

/**
 * Two Sum Problem Solution
 * 
 * Problem: Given an array of integers and a target sum, return indices of two numbers that add up to target.
 * 
 * Approach: Single-pass HashMap lookup
 * - For each number, calculate its complement (target - current number)
 * - Check if complement exists in HashMap (O(1) lookup)
 * - If found: return stored index and current index
 * - If not found: store current number and index in HashMap
 * 
 * Time Complexity: O(n) - single pass through array
 * Space Complexity: O(n) - HashMap storage in worst case
 * 
 * Example: nums=[2,7,11,15], target=9 → return [0,1] (2+7=9)
 */
public class TwoSum {
        public int[] twoSum(int[] nums, int target) {
            if (nums == null) throw new IllegalArgumentException("Input array cannot be null");
            HashMap<Integer, Integer> complements = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];

                if (complements.containsKey(complement)) {
                    return new int[] { complements.get(complement), i };
                }

                complements.put(nums[i], i);
            }

            return new int[] {};
        }
}
