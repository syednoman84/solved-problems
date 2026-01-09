package problems.DynamicProgrammingII;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LongestCommonSubsequenceTest {
    private final LongestCommonSubsequence solution = new LongestCommonSubsequence();

    @Test
    void testLongestCommonSubsequence() {
        assertEquals(3, solution.longestCommonSubsequence("abcde", "ace"));
        assertEquals(3, solution.longestCommonSubsequence("abc", "abc"));
        assertEquals(0, solution.longestCommonSubsequence("abc", "def"));
        assertEquals(1, solution.longestCommonSubsequence("a", "a"));
        assertEquals(3, solution.longestCommonSubsequence("abcd", "acbd"));
    }
}