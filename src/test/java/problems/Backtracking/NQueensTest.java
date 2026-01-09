package problems.Backtracking;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class NQueensTest {
    private final NQueens solution = new NQueens();

    @Test
    void testSolveNQueens() {
        assertEquals(2, solution.solveNQueens(4).size());
        assertEquals(1, solution.solveNQueens(1).size());
        assertEquals(0, solution.solveNQueens(2).size());
        assertEquals(0, solution.solveNQueens(3).size());
        assertEquals(10, solution.solveNQueens(5).size());
    }
}