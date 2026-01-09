package problems.ArraysHashing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContainsDuplicateTest {
    private final ContainsDuplicate solution = new ContainsDuplicate();

    @Test
    void testContainsDuplicate() {
        assertTrue(solution.containsDuplicate(new int[]{1,2,3,1}));
        assertFalse(solution.containsDuplicate(new int[]{1,2,3,4}));
        assertTrue(solution.containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}));
        assertFalse(solution.containsDuplicate(new int[]{1}));
        assertTrue(solution.containsDuplicate(new int[]{1,1}));
    }
}