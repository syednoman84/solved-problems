package problems.Backtracking;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class SubsetsTest {
    private final Subsets solution = new Subsets();

    @Test
    void testSubsets() {
        assertEquals(8, solution.subsets(new int[]{1,2,3}).size());
        assertEquals(2, solution.subsets(new int[]{0}).size());
        assertEquals(4, solution.subsets(new int[]{1,2}).size());
        assertEquals(1, solution.subsets(new int[]{}).size());
        assertEquals(16, solution.subsets(new int[]{1,2,3,4}).size());
    }
}