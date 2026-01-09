package problems.ArraysHashing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LongestConsecutiveSequenceTest {
    private final LongestConsecutiveSequence solution = new LongestConsecutiveSequence();

    @Test
    void testLongestConsecutive() {
        assertEquals(4, solution.longestConsecutive(new int[]{100,4,200,1,3,2}));
        assertEquals(9, solution.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
        assertEquals(0, solution.longestConsecutive(new int[]{}));
        assertEquals(1, solution.longestConsecutive(new int[]{1}));
        assertEquals(3, solution.longestConsecutive(new int[]{1,2,0,1}));
        assertEquals(7, solution.longestConsecutive(new int[]{9,1,4,7,3,-1,0,5,8,-1,6}));
    }
}