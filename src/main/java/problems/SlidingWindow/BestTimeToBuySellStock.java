package problems.SlidingWindow;

/*
 * 121. Best Time to Buy and Sell Stock
 * Easy
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 * Example 1:
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *
 * Example 2:
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 *
 * Constraints:
 * - 1 <= prices.length <= 10^5
 * - 0 <= prices[i] <= 10^4
 */
public class BestTimeToBuySellStock {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 1) return 0;
        int maxP = 0;
        int l = 0, r = 1;
        
        while(r < n) {
            if(prices[l] < prices[r]) {
                int profit = prices[r] - prices[l];
                maxP = Math.max(maxP, profit);
            } else
                l = r;
            r++;
        }
        return maxP;
    }

    public static void main(String[] args) {
        BestTimeToBuySellStock solution = new BestTimeToBuySellStock();
        
        // Test case 1: prices = [7,6,4,3,1]
        int result1 = solution.maxProfit(new int[]{7, 6, 4, 3, 1});
        int expected1 = 0;
        String status1 = result1 == expected1 ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: " + expected1 + ", Got: " + result1 + " [" + status1 + "]");
    }
}
