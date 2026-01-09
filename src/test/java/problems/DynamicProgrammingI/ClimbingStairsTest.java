package problems.DynamicProgrammingI;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClimbingStairsTest {
    private final ClimbingStairs solution = new ClimbingStairs();

    @Test
    void testClimbStairs() {
        assertEquals(2, solution.climbStairs(2));
        assertEquals(3, solution.climbStairs(3));
        assertEquals(1, solution.climbStairs(1));
        assertEquals(5, solution.climbStairs(4));
        assertEquals(8, solution.climbStairs(5));
    }
}