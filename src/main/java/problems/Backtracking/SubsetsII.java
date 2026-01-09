package problems.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [90. Subsets II](https://leetcode.com/problems/subsets-ii/)
 * Medium
 *
 * Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 * Example 1:
 * Input: nums = [1,2,2]
 * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 *
 * Example 2:
 * Input: nums = [0]
 * Output: [[],[0]]
 *
 * Constraints:
 * - 1 <= nums.length <= 10
 * - -10 <= nums[i] <= 10
 *
 * Approach:
 * Same as Subsets
 * - to skip duplicates, before making the 2nd backtracking call we check the current and next element
 * - while those are equal we keep skipping to the next index
 *
 * Complexity Analysis:
 * - Time Complexity: O(2^N)
 * - Space Complexity: O(N)
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), ans);
        return ans;
    }
    
    private void backtrack(int[] nums, int index, List<Integer> tmp, List<List<Integer>> ans) {
        if(index > nums.length)
            return;
        if(index == nums.length) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        tmp.add(nums[index]);
        backtrack(nums, index+1, tmp, ans);
        tmp.remove(tmp.size()-1);
        while(index+1 < nums.length && nums[index] == nums[index+1])
            index++;
        backtrack(nums, index+1, tmp, ans);
    }

    public static void main(String[] args) {
        SubsetsII solution = new SubsetsII();
        
        // Test case 1
        int[] nums = {1,2,2};
        List<List<Integer>> result = solution.subsetsWithDup(nums);
        int expected = 6;
        String status = result.size() == expected ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected size: " + expected + ", Got: " + result.size() + " [" + status + "]");
    }
}
