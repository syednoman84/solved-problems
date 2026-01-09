package problems.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * [46. Permutations](https://leetcode.com/problems/permutations/)
 * Medium
 *
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 *
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * Example 2:
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 *
 * Example 3:
 * Input: nums = [1]
 * Output: [[1]]
 *
 * Constraints:
 * - 1 <= nums.length <= 6
 * - -10 <= nums[i] <= 10
 * - All the integers of nums are unique.
 *
 * Approach:
 * - we have n choices initially, after each selection we can't take that element again
 * - take a mark array to keep track of what elements fron the nums array which are already select in the current path
 * for(int i = 0; i < nums.length; i++) {
 *     if(mark[i] == false) {
 *         mark[i] = true;
 *         tmp.add(nums[i]);
 *         backtrack(nums, mark, tmp, ans);
 *         tmp.remove(tmp.size()-1);
 *         mark[i] = false;
 *     }
 * }
 *
 * Complexity Analysis:
 * - Time Complexity: O(N^N)
 * - Space Complexity: O(N)
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        boolean[] mark = new boolean[nums.length];
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, mark, new ArrayList<>(), ans);
        return ans;
    }
    
    private void backtrack(int[] nums, boolean[] mark, List<Integer> tmp, List<List<Integer>> ans) {
        if(tmp.size() == nums.length) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(mark[i] == false) {
                mark[i] = true;
                tmp.add(nums[i]);
                backtrack(nums, mark, tmp, ans);
                tmp.remove(tmp.size()-1);
                mark[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Permutations solution = new Permutations();
        
        // Test case 1
        int[] nums = {1,2,3};
        List<List<Integer>> result = solution.permute(nums);
        int expected = 6;
        String status = result.size() == expected ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected size: " + expected + ", Got: " + result.size() + " [" + status + "]");
    }
}
