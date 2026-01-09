package problems.DynamicProgrammingII;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UniquePathsTest {
    private final UniquePaths solution = new UniquePaths();

    @Test
    void testUniquePaths() {
        assertEquals(28, solution.uniquePaths(3, 7));
        assertEquals(3, solution.uniquePaths(3, 2));
        assertEquals(1, solution.uniquePaths(1, 1));
        assertEquals(1, solution.uniquePaths(1, 10));
        assertEquals(6, solution.uniquePaths(3, 3));
    }
}