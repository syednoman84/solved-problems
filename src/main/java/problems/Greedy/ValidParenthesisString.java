package problems.Greedy;

/**
 * [678. Valid Parenthesis String](https://leetcode.com/problems/valid-parenthesis-string/)
 * Medium
 *
 * Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.
 * The following rules define a valid string:
 * - Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * - Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * - Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * - '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
 *
 * Example 1:
 * Input: s = "()"
 * Output: true
 *
 * Example 2:
 * Input: s = "(*)"
 * Output: true
 *
 * Example 3:
 * Input: s = "(*))"
 * Output: true
 *
 * Constraints:
 * - 1 <= s.length <= 100
 * - s[i] is '(', ')' or '*'.
 *
 * Approach:
 * - Greedy approach
 * - Track minimum and maximum possible open parentheses
 * - For '(': increment both min and max
 * - For ')': decrement both min and max
 * - For '*': decrement min (treat as ')'), increment max (treat as '(')
 * - If max becomes negative, return false
 * - If min becomes negative, reset to 0
 * - At the end, check if min is 0
 *
 * Complexity Analysis:
 * - Time Complexity: O(n)
 * - Space Complexity: O(1)
 */
public class ValidParenthesisString {
    public boolean checkValidString(String s) {
        int leftMin = 0, leftMax = 0;
        for (char ch: s.toCharArray()) {
            if (ch == '(') {
                leftMin++;
                leftMax++;
            }
            else if (ch == ')') {
                leftMin--;
                leftMax--;
            }
            else {
                leftMin--;
                leftMax++;
            }
            if (leftMax < 0) {
                return false;
            }
            if (leftMin < 0) {
                leftMin = 0;
            }
        }
        return leftMin == 0;
    }

    public static void main(String[] args) {
        ValidParenthesisString solution = new ValidParenthesisString();
        
        // Test case 1
        String s = "(*)";
        boolean result = solution.checkValidString(s);
        boolean expected = true;
        String status = result == expected ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: " + expected + ", Got: " + result + " [" + status + "]");
    }
}
