package problems.Backtracking;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class PermutationsTest {
    private final Permutations solution = new Permutations();

    @Test
    void testPermute() {
        assertEquals(6, solution.permute(new int[]{1,2,3}).size());
        assertEquals(2, solution.permute(new int[]{0,1}).size());
        assertEquals(1, solution.permute(new int[]{1}).size());
        assertEquals(24, solution.permute(new int[]{1,2,3,4}).size());
        assertEquals(1, solution.permute(new int[]{}).size());
    }
}