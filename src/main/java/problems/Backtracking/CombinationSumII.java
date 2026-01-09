package problems.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [40. Combination Sum II](https://leetcode.com/problems/combination-sum-ii/)
 * Medium
 *
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
 * Each number in candidates may only be used once in the combination.
 * Note: The solution set must not contain duplicate combinations.
 *
 * Example 1:
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output: [[1,1,6],[1,2,5],[1,7],[2,6]]
 *
 * Example 2:
 * Input: candidates = [2,5,2,1,2], target = 5
 * Output: [[1,2,2],[5]]
 *
 * Constraints:
 * - 1 <= candidates.length <= 100
 * - 1 <= candidates[i] <= 50
 * - 1 <= target <= 30
 *
 * Approach:
 * - We can't contain duplicates, so we can't use the same numbers twice
 * - Before making the 2nd recursive call, we check the current and next element
 * - while those are same we keep skipping them
 *
 * Complexity Analysis:
 * - Time Complexity: O(2^N)
 * - Space Complexity: O(N)
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, 0, target, new ArrayList<>(), ans);
        return ans;
    }
    
    private void backtrack(int[] nums, int index, int target, List<Integer> tmp, List<List<Integer>> ans) {
        if(target == 0) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        if(index >= nums.length || target < 0)
            return;
        
        tmp.add(nums[index]);
        backtrack(nums, index+1, target-nums[index], tmp, ans);
        tmp.remove(tmp.size()-1);
        while(index+1 < nums.length && nums[index] == nums[index+1])
            index++;
        backtrack(nums, index+1, target, tmp, ans);
    }

    public static void main(String[] args) {
        CombinationSumII solution = new CombinationSumII();
        
        // Test case 1
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> result = solution.combinationSum2(candidates, target);
        int expected = 4;
        String status = result.size() == expected ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected size: " + expected + ", Got: " + result.size() + " [" + status + "]");
    }
}
