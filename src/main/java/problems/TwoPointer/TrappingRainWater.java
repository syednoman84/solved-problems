package problems.TwoPointer;

/*
 * 42. Trapping Rain Water
 * Hard
 * 
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, 
 * compute how much water it can trap after raining.
 * 
 * Example 1:
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
 * In this case, 6 units of rain water (blue section) are being trapped.
 * 
 * Example 2:
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 * 
 * Constraints:
 * - n == height.length
 * - 1 <= n <= 2 * 10^4
 * - 0 <= height[i] <= 10^5
 * 
 * Approach:
 * - Use two pointers (left and right) with leftMax and rightMax variables
 * - If leftMax <= rightMax, update leftMax and calculate trapped water at left position
 * - Otherwise, update rightMax and calculate trapped water at right position
 * - Time Complexity: O(N)
 * - Space Complexity: O(1)
 */

public class TrappingRainWater {
    public int trap(int[] height) {
        int left = 0, right = height.length-1;
        int lMax = height[0], rMax = height[right];
        int ans = 0;
        while(left <= right) {
            if(lMax <= rMax) {
                lMax = Math.max(lMax, height[left]);
                int val = Math.min(lMax, rMax)-height[left];
                ans += val < 0 ? 0 : val;
                left++;
            } else {
                rMax = Math.max(rMax, height[right]);
                int val = Math.min(lMax, rMax)-height[right];
                ans += val < 0 ? 0 : val;
                right--;
            }
        }       
        return ans;
    }

    public static void main(String[] args) {
        TrappingRainWater solution = new TrappingRainWater();
        
        // Test case 1: height = [4,2,0,3,2,5]
        int result1 = solution.trap(new int[]{4, 2, 0, 3, 2, 5});
        int expected1 = 9;
        String status1 = result1 == expected1 ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: " + expected1 + ", Got: " + result1 + " [" + status1 + "]");
    }
}
