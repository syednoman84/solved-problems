package problems.DynamicProgrammingII;

/*
    You are given an array of integers nums of size n. The ith element represents a balloon with an integer value of nums[i]. You must burst all of the balloons.

    If you burst the ith balloon, you will receive nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1 goes out of bounds of the array, then assume the out of bounds value is 1.

    Return the maximum number of coins you can receive by bursting all of the balloons.

    Example 1:

    Input: nums = [4,2,3,7]

    Output: 143

    Explanation:
    nums = [4,2,3,7] --> [4,3,7] --> [4,7] --> [7] --> []
    coins =  4*2*3    +   4*3*7   +  1*4*7  + 1*7*1 = 143
 */

public class BalloonBurst{
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n + 2];
        newNums[0] = newNums[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            newNums[i + 1] = nums[i];
        }

        int[][] dp = new int[n + 2][n + 2];
        for (int l = n; l >= 1; l--) {
            for (int r = l; r <= n; r++) {
                for (int i = l; i <= r; i++) {
                    int coins = newNums[l - 1] * newNums[i] * newNums[r + 1];
                    coins += dp[l][i - 1] + dp[i + 1][r];
                    dp[l][r] = Math.max(dp[l][r], coins);
                }
            }
        }

        return dp[1][n];
    }
}