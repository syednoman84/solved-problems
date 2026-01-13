package problems.Greedy;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

/**
 * Test Suite for all Greedy problems
 * 
 * This suite runs all unit tests for the Greedy package, covering:
 * - Kadane's algorithm for maximum subarray
 * - Jump game algorithms for reachability and optimization
 * - Gas station circular route optimization
 * - Hand of straights consecutive grouping
 * - Valid parenthesis string with wildcards
 */
@Suite
@SelectClasses({
    MaximumSubarrayTest.class,
    JumpTest.class,
    JumpIITest.class,
    GasStationTest.class,
    HandOfStraightsTest.class,
    ValidParenthesisStringTest.class
})
public class GreedyTestSuite {
    // Test suite class - no additional code needed
    // JUnit 5 will automatically discover and run all specified test classes
}