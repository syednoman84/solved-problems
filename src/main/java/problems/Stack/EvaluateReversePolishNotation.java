/*
 * 150. Evaluate Reverse Polish Notation
 * Medium
 *
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, and /. Each operand may be an integer or another expression.
 * Note that division between two integers should truncate toward zero.
 * It is guaranteed that the given RPN expression is always valid.
 *
 * Example 1:
 * Input: tokens = ["2","1","+","3","*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 *
 * Example 2:
 * Input: tokens = ["4","13","5","/","+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 *
 * Constraints:
 * - 1 <= tokens.length <= 10^4
 * - tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].
 */
import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String s : tokens) {
            if(s.equals("+")) {
                st.push(st.pop()+st.pop());
            } else if(s.equals("-")) {
                int n2 = st.pop();
                int n1 = st.pop();
                st.push(n1-n2);
            } else if(s.equals("*")) {
                st.push(st.pop()*st.pop());
            } else if(s.equals("/")) {
                int n2 = st.pop();
                int n1 = st.pop();
                st.push(n1/n2);
            } else {
                st.push(Integer.parseInt(s));
            }
        }
        return st.peek();
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation solution = new EvaluateReversePolishNotation();
        
        // Test case 1: tokens = ["2","1","+","3","*"]
        int result1 = solution.evalRPN(new String[]{"2", "1", "+", "3", "*"});
        int expected1 = 9;
        String status1 = result1 == expected1 ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: " + expected1 + ", Got: " + result1 + " [" + status1 + "]");
    }
}
