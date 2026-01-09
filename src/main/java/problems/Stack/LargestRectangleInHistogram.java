package problems.Stack;

/*
 * 84. Largest Rectangle in Histogram
 * Hard
 *
 * Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.
 *
 * Example 1:
 * Input: heights = [2,1,5,6,2,3]
 * Output: 10
 * Explanation: The largest rectangle is shown in the red area, which has an area = 10 units.
 *
 * Example 2:
 * Input: heights = [2,4]
 * Output: 4
 *
 * Constraints:
 * - 1 <= heights.length <= 10^5
 * - 0 <= heights[i] <= 10^4
 */
import java.util.Stack;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<int[]> st = new Stack<>();
        for(int i = 0; i < heights.length; i++) {
            int start = i;
            while(!st.isEmpty() && st.peek()[1] > heights[i]) {
                int[] pair = st.pop();
                maxArea = Math.max(maxArea, pair[1] * (i-pair[0]));
                start = pair[0];
            }
            st.push(new int[]{start, heights[i]});
        }
        
        while(!st.isEmpty()) {
            int[] pair = st.pop();
            maxArea = Math.max(maxArea, pair[1] * (heights.length-pair[0]));
        }
        
        return maxArea;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram solution = new LargestRectangleInHistogram();
        
        // Test case 1: heights = [2,4]
        int result1 = solution.largestRectangleArea(new int[]{2, 4});
        int expected1 = 4;
        String status1 = result1 == expected1 ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: " + expected1 + ", Got: " + result1 + " [" + status1 + "]");
    }
}
