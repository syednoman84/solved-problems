/*
 * 739. Daily Temperatures
 * Medium
 *
 * Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature.
 * If there is no future day for which this is possible, keep answer[i] == 0 instead.
 *
 * Example 1:
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 *
 * Example 2:
 * Input: temperatures = [30,40,50,60]
 * Output: [1,1,1,0]
 *
 * Example 3:
 * Input: temperatures = [30,60,90]
 * Output: [1,1,0]
 *
 * Constraints:
 * - 1 <= temperatures.length <= 10^5
 * - 30 <= temperatures[i] <= 100
 */
import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<int[]> st = new Stack<>();
        int[] res = new int[n];
        
        for(int i = 0; i < n; i++) {
            while(!st.empty() && st.peek()[0] < temperatures[i]) {
                int[] temp = st.pop();
                res[temp[1]] = i-temp[1];
            }
            st.push(new int[]{temperatures[i], i});
        }
        
        return res;
    }

    public static void main(String[] args) {
        DailyTemperatures solution = new DailyTemperatures();
        
        // Test case 1: temperatures = [30,60,90]
        int[] result1 = solution.dailyTemperatures(new int[]{30, 60, 90});
        String expected1 = "[1, 1, 0]";
        String actual1 = java.util.Arrays.toString(result1);
        String status1 = actual1.equals(expected1) ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: " + expected1 + ", Got: " + actual1 + " [" + status1 + "]");
    }
}
