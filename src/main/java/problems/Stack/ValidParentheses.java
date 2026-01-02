package problems.Stack;

/*
 * 20. Valid Parentheses
 * Easy
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * - Open brackets must be closed by the same type of brackets.
 * - Open brackets must be closed in the correct order.
 *
 * Example 1:
 * Input: s = "()"
 * Output: true
 *
 * Example 2:
 * Input: s = "()[]{}"
 * Output: true
 *
 * Example 3:
 * Input: s = "(]"
 * Output: false
 *
 * Constraints:
 * - 1 <= s.length <= 10^4
 * - s consists of parentheses only '()[]{}'.
 */
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[')
                st.push(c);
            else if(c == ')' && !st.empty()) {
                char ch = st.pop();
                if(ch != '(')
                    return false;
            } else if(c == '}' && !st.empty()) {
                char ch = st.pop();
                if(ch != '{')
                    return false;
            } else if(c == ']' && !st.empty()) {
                char ch = st.pop();
                if(ch != '[')
                    return false;
            } else
                return false;
        }
        
        return st.empty();
    }

    public static void main(String[] args) {
        ValidParentheses solution = new ValidParentheses();
        
        // Test case 1: s = "()"
        boolean result1 = solution.isValid("()");
        boolean expected1 = true;
        String status1 = result1 == expected1 ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: " + expected1 + ", Got: " + result1 + " [" + status1 + "]");
    }
}
