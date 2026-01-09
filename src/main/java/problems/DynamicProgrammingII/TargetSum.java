package problems.DynamicProgrammingII;

/*
You are given an array of integers nums and an integer target.

For each number in the array, you can choose to either add or subtract it to a total sum.

    For example, if nums = [1, 2], one possible sum would be "+1-2=-1".

If nums=[1,1], there are two different ways to sum the input numbers to get a sum of 0: "+1-1" and "-1+1".

Return the number of different ways that you can build the expression such that the total sum equals target.

Example 1:

Input: nums = [2,2,2], target = 2

Output: 3

Explanation: There are 3 different ways to sum the input numbers to get a sum of 2.
+2 +2 -2 = 2
+2 -2 +2 = 2
-2 +2 +2 = 2

Constraints:

    1 <= nums.length <= 20
    0 <= nums[i] <= 1000
    -1000 <= target <= 1000
 */

import java.util.HashMap;
import java.util.Map;

public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 1);

        for (int num : nums) {
            Map<Integer, Integer> nextDp = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry : dp.entrySet()) {
                int total = entry.getKey();
                int count = entry.getValue();
                nextDp.put(total + num,
                        nextDp.getOrDefault(total + num, 0) + count);
                nextDp.put(total - num,
                        nextDp.getOrDefault(total - num, 0) + count);
            }
            dp = nextDp;
        }
        return dp.getOrDefault(target, 0);
    }
}