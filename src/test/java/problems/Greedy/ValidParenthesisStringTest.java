package problems.Greedy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ValidParenthesisStringTest {

    @Test
    void testCheckValidString() {
        ValidParenthesisString solution = new ValidParenthesisString();
        
        // Test case 1: Simple valid
        String s1 = "()";
        assertTrue(solution.checkValidString(s1));
        
        // Test case 2: With wildcard
        String s2 = "(*)";
        assertTrue(solution.checkValidString(s2));
        
        // Test case 3: Extra closing with wildcard
        String s3 = "(*))";
        assertTrue(solution.checkValidString(s3));
        
        // Test case 4: Only wildcards
        String s4 = "***";
        assertTrue(solution.checkValidString(s4));
        
        // Test case 5: Invalid - too many closing
        String s5 = "())";
        assertFalse(solution.checkValidString(s5));
        
        // Test case 6: Complex valid pattern
        String s6 = "(*))";
        assertTrue(solution.checkValidString(s6));
        
        // Test case 7: All opening
        String s7 = "(((";
        assertFalse(solution.checkValidString(s7));
        
        // Test case 8: Wildcards as empty
        String s8 = "*";
        assertTrue(solution.checkValidString(s8));
        
        // Test case 9: Complex nested
        String s9 = "((*))";
        assertTrue(solution.checkValidString(s9));
        
        // Test case 10: Invalid pattern
        String s10 = "((*)";
        assertTrue(solution.checkValidString(s10));
        
        // Test case 11: Multiple wildcards
        String s11 = "***)";
        assertTrue(solution.checkValidString(s11));
    }
}