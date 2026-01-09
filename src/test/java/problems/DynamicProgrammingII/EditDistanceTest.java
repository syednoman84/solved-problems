package problems.DynamicProgrammingII;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EditDistanceTest {
    private final EditDistance solution = new EditDistance();

    @Test
    void testMinDistance() {
        assertEquals(3, solution.minDistance("horse", "ros"));
        assertEquals(5, solution.minDistance("intention", "execution"));
        assertEquals(0, solution.minDistance("", ""));
        assertEquals(1, solution.minDistance("a", ""));
        assertEquals(1, solution.minDistance("", "a"));
    }
}