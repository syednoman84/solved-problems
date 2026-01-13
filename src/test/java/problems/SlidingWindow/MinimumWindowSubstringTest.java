package problems.SlidingWindow;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MinimumWindowSubstringTest {
    private final MinimumWindowSubstring solution = new MinimumWindowSubstring();

    @Test
    void testMinWindow() {
        assertEquals("BANC", solution.minWindow("ADOBECODEBANC", "ABC"));
        assertEquals("a", solution.minWindow("a", "a"));
        assertEquals("", solution.minWindow("a", "aa"));
        assertEquals("b", solution.minWindow("ab", "b"));
    }
}