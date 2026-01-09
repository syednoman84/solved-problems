package problems.MathGeometry;

/**
 * [202. Happy Number](https://leetcode.com/problems/happy-number/)
 * Easy
 *
 * Write an algorithm to determine if a number n is happy.
 * A happy number is a number defined by the following process:
 * - Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * - Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * - Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 *
 * Example 1:
 * Input: n = 19
 * Output: true
 * Explanation:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 *
 * Example 2:
 * Input: n = 2
 * Output: false
 *
 * Constraints:
 * - 1 <= n <= 2^31 - 1
 *
 * Approach:
 * - Use Floyd's cycle detection algorithm (slow and fast pointers)
 * - If they meet at 1, it's a happy number
 * - If they meet at any other number, it's in a cycle
 *
 * Complexity Analysis:
 * - Time Complexity: O(log n)
 * - Space Complexity: O(1)
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = sum(slow);
            fast = sum(sum(fast));
        } while(slow != fast);
        return slow == 1;
    }
    
    private int sum(int n) {
        int sum = 0;
        while(n > 0) {
            int digit = n % 10;
            sum += (digit*digit);
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        HappyNumber solution = new HappyNumber();
        
        // Test case 1: n = 2
        int result1 = solution.isHappy(2) ? 1 : 0;
        int expected1 = 0;
        String status1 = result1 == expected1 ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: " + expected1 + ", Got: " + result1 + " [" + status1 + "]");
    }
}
