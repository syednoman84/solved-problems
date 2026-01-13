package problems.Stack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Arrays;

class GenerateParenthesesTest {
    private final GenerateParentheses solution = new GenerateParentheses();

    @Test
    void testGenerateParenthesis() {
        assertEquals(Arrays.asList("()"), solution.generateParenthesis(1));
        assertTrue(solution.generateParenthesis(2).containsAll(Arrays.asList("(())","()()")) && solution.generateParenthesis(2).size() == 2);
        assertEquals(5, solution.generateParenthesis(3).size());
        assertTrue(solution.generateParenthesis(3).contains("((()))"));
    }
}