package problems.Backtracking;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class PalindromePartitioningTest {
    private final PalindromePartitioning solution = new PalindromePartitioning();

    @Test
    void testPartition() {
        assertEquals(2, solution.partition("aab").size());
        assertEquals(1, solution.partition("a").size());
        assertEquals(2, solution.partition("aba").size());
        assertEquals(1, solution.partition("abcde").size());
        assertEquals(4, solution.partition("abccba").size());
    }
}