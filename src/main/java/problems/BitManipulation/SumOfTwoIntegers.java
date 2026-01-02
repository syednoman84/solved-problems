/**
 * [371. Sum of Two Integers](https://leetcode.com/problems/sum-of-two-integers/)
 * Medium
 *
 * Given two integers a and b, return the sum of the two integers without using the operators + and -.
 *
 * Example 1:
 * Input: a = 1, b = 2
 * Output: 3
 *
 * Example 2:
 * Input: a = 2, b = 3
 * Output: 5
 *
 * Constraints:
 * - -1000 <= a, b <= 1000
 *
 * Approach:
 * - Use XOR for addition without carry: a ^ b
 * - Use AND and left shift for carry: (a & b) << 1
 * - Repeat until there's no carry left
 *
 * Complexity Analysis:
 * - Time Complexity: O(1) (limited by the number of bits)
 * - Space Complexity: O(1)
 */
public class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        while(b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }

    public static void main(String[] args) {
        SumOfTwoIntegers solution = new SumOfTwoIntegers();
        
        // Test case 1
        int a = 1, b = 2;
        int result = solution.getSum(a, b);
        int expected = 3;
        String status = result == expected ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: " + expected + ", Got: " + result + " [" + status + "]");
    }
}
