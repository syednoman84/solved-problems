package problems.DynamicProgrammingI;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HouseRobberTest {
    private final HouseRobber solution = new HouseRobber();

    @Test
    void testRob() {
        assertEquals(4, solution.rob(new int[]{1,2,3,1}));
        assertEquals(12, solution.rob(new int[]{2,7,9,3,1}));
        assertEquals(5, solution.rob(new int[]{5}));
        assertEquals(2, solution.rob(new int[]{1,2}));
        assertEquals(11, solution.rob(new int[]{2,1,1,9}));
    }
}