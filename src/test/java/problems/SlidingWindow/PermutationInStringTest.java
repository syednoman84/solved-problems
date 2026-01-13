package problems.SlidingWindow;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PermutationInStringTest {
    private final PermutationInString solution = new PermutationInString();

    @Test
    void testCheckInclusion() {
        assertTrue(solution.checkInclusion("ab", "eidbaooo"));
        assertFalse(solution.checkInclusion("ab", "eidboaoo"));
        assertTrue(solution.checkInclusion("a", "ab"));
        assertFalse(solution.checkInclusion("ab", "a"));
    }
}