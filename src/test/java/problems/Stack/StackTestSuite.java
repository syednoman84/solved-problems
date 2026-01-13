package problems.Stack;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
    ValidParenthesesTest.class,
    MinStackTest.class,
    EvaluateReversePolishNotationTest.class,
    GenerateParenthesesTest.class,
    DailyTemperaturesTest.class,
    CarFleetTest.class,
    LargestRectangleInHistogramTest.class
})
public class StackTestSuite {
}