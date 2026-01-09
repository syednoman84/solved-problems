package problems.Backtracking;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class CombinationSumIITest {
    private final CombinationSumII solution = new CombinationSumII();

    @Test
    void testCombinationSum2() {
        assertEquals(4, solution.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8).size());
        assertEquals(2, solution.combinationSum2(new int[]{2,5,2,1,2}, 5).size());
        assertEquals(0, solution.combinationSum2(new int[]{1}, 2).size());
        assertEquals(1, solution.combinationSum2(new int[]{1}, 1).size());
        assertEquals(1, solution.combinationSum2(new int[]{1,1,1}, 3).size());
    }
}