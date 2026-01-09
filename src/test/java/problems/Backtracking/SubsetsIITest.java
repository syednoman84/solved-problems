package problems.Backtracking;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class SubsetsIITest {
    private final SubsetsII solution = new SubsetsII();

    @Test
    void testSubsetsWithDup() {
        assertEquals(6, solution.subsetsWithDup(new int[]{1,2,2}).size());
        assertEquals(2, solution.subsetsWithDup(new int[]{0}).size());
        assertEquals(3, solution.subsetsWithDup(new int[]{1,1}).size());
        assertEquals(10, solution.subsetsWithDup(new int[]{4,4,4,1,4}).size());
        assertEquals(1, solution.subsetsWithDup(new int[]{}).size());
    }
}