/**
 * [50. Pow(x, n)](https://leetcode.com/problems/powx-n/)
 * Medium
 *
 * Implement pow(x, n), which calculates x raised to the power n (i.e., x^n).
 *
 * Example 1:
 * Input: x = 2.00000, n = 10
 * Output: 1024.00000
 *
 * Example 2:
 * Input: x = 2.10000, n = 3
 * Output: 9.26100
 *
 * Example 3:
 * Input: x = 2.00000, n = -2
 * Output: 0.25000
 * Explanation: 2^-2 = 1/2^2 = 1/4 = 0.25
 *
 * Constraints:
 * - -100.0 < x < 100.0
 * - -2^31 <= n <= 2^31-1
 * - -10^4 <= x^n <= 10^4
 *
 * Approach:
 * - Recursion with binary exponentiation
 * - we can divide the power by 2 and same value can be reused
 * - For non-negative:
 *   - for even: pow(x, n) = pow(x, n/2)*pow(x,n/2)
 *   - for odd: pow(x, n) = x*pow(x, n/2)*pow(x,n/2)
 * - For negative:
 *   - for even: pow(x, n) = pow(x, n/2)*pow(x,n/2)
 *   - for odd: pow(x, n) = 1/x*pow(x, n/2)*pow(x,n/2)
 *
 * Complexity Analysis:
 * - Time Complexity: O(log n)
 * - Space Complexity: O(log n)
 */
public class PowXN {
    public double myPow(double x, int n) {
        if(n < 0)
            return myPowNeg(x, n);
        return myPowPos(x, n);
    }
    
    private double myPowNeg(double x, int n) {
        if(x == 1 || n == 0)
            return 1;
        if(n == -1)
            return 1/x;
        double ans = myPow(x, n/2);
        ans *= ans;
        if(n%2 != 0)
            return ans/x;
        return ans;
    }
    
    private double myPowPos(double x, int n) {
        if(x == 1 || n == 0)
            return 1;
        double ans = myPow(x, n/2);
        ans *= ans;
        if(n%2 != 0)
            return ans*x;
        return ans;
    }

    public static void main(String[] args) {
        PowXN solution = new PowXN();
        
        // Test case 1: x = 2.00000, n = 10
        double result1 = solution.myPow(2.0, 10);
        double expected1 = 1024.0;
        String status1 = Math.abs(result1 - expected1) < 0.00001 ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: " + expected1 + ", Got: " + result1 + " [" + status1 + "]");
    }
}
