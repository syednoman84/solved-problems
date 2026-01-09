package problems.Backtracking;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class CombinationSumTest {
    private final CombinationSum solution = new CombinationSum();

    @Test
    void testCombinationSum() {
        assertEquals(2, solution.combinationSum(new int[]{2,3,6,7}, 7).size());
        assertEquals(3, solution.combinationSum(new int[]{2,3,5}, 8).size());
        assertEquals(0, solution.combinationSum(new int[]{2}, 1).size());
        assertEquals(1, solution.combinationSum(new int[]{1}, 1).size());
        assertEquals(1, solution.combinationSum(new int[]{2,3,5}, 2).size());
    }
}