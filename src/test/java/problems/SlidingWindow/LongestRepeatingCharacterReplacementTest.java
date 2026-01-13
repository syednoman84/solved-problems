package problems.SlidingWindow;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LongestRepeatingCharacterReplacementTest {
    private final LongestRepeatingCharacterReplacement solution = new LongestRepeatingCharacterReplacement();

    @Test
    void testCharacterReplacement() {
        assertEquals(4, solution.characterReplacement("ABAB", 2));
        assertEquals(4, solution.characterReplacement("AABABBA", 1));
        assertEquals(1, solution.characterReplacement("ABAB", 0));
        assertEquals(1, solution.characterReplacement("A", 0));
    }
}