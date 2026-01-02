/*
 * 22. Generate Parentheses
 * Medium
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * Example 1:
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 *
 * Example 2:
 * Input: n = 1
 * Output: ["()"]
 *
 * Constraints:
 * - 1 <= n <= 8
 */
import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>(); 
        generate(0, n, 0, 0, ans, "");
        return ans;
    }
    
    private void generate(int index, int n, int lCount, int rCount, List<String> ans, String op) {
        if(lCount > n || rCount > n)
            return;
        if(lCount == rCount && lCount == n) {
            ans.add(op);
        }
        if(lCount > rCount) {
            String op1 = op + ")";
            generate(index+1, n, lCount, rCount+1, ans, op1);
        }
        String op2 = op + "(";
        generate(index+1, n, lCount+1, rCount, ans, op2);
    }

    public static void main(String[] args) {
        GenerateParentheses solution = new GenerateParentheses();
        
        // Test case 1: n = 1
        List<String> result1 = solution.generateParenthesis(1);
        boolean expected1 = true;
        boolean actual1 = result1.size() == 1 && result1.get(0).equals("()");
        String status1 = actual1 == expected1 ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: " + expected1 + ", Got: " + actual1 + " [" + status1 + "]");
    }
}
