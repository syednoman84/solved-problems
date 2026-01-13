package problems.Stack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EvaluateReversePolishNotationTest {
    private final EvaluateReversePolishNotation solution = new EvaluateReversePolishNotation();

    @Test
    void testEvalRPN() {
        assertEquals(9, solution.evalRPN(new String[]{"2","1","+","3","*"}));
        assertEquals(6, solution.evalRPN(new String[]{"4","13","5","/","+"}));
        assertEquals(22, solution.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
        assertEquals(13, solution.evalRPN(new String[]{"13"}));
    }
}