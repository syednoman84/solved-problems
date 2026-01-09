package problems.Graphs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SurroundedRegionsTest {

    @Test
    void testSolve() {
        SurroundedRegions solution = new SurroundedRegions();
        
        // Test case 1: Standard example with surrounded regions
        char[][] board1 = {
            {'X','X','X','X'},
            {'X','O','O','X'},
            {'X','X','O','X'},
            {'X','O','X','X'}
        };
        char[][] expected1 = {
            {'X','X','X','X'},
            {'X','X','X','X'},
            {'X','X','X','X'},
            {'X','O','X','X'}
        };
        solution.solve(board1);
        assertArrayEquals(expected1, board1);
        
        // Test case 2: Single cell
        char[][] board2 = {{'X'}};
        char[][] expected2 = {{'X'}};
        solution.solve(board2);
        assertArrayEquals(expected2, board2);
        
        // Test case 3: O on boundary - should not be captured
        char[][] board3 = {
            {'O','X','X'},
            {'X','O','X'},
            {'X','X','O'}
        };
        char[][] expected3 = {
            {'O','X','X'},
            {'X','X','X'},
            {'X','X','O'}
        };
        solution.solve(board3);
        assertArrayEquals(expected3, board3);
        
        // Test case 4: All O's
        char[][] board4 = {
            {'O','O'},
            {'O','O'}
        };
        char[][] expected4 = {
            {'O','O'},
            {'O','O'}
        };
        solution.solve(board4);
        assertArrayEquals(expected4, board4);
        
        // Test case 5: All X's
        char[][] board5 = {
            {'X','X'},
            {'X','X'}
        };
        char[][] expected5 = {
            {'X','X'},
            {'X','X'}
        };
        solution.solve(board5);
        assertArrayEquals(expected5, board5);
        
        // Test case 6: Complex pattern with connected boundary O's
        char[][] board6 = {
            {'O','O','O'},
            {'O','X','O'},
            {'O','O','O'}
        };
        char[][] expected6 = {
            {'O','O','O'},
            {'O','X','O'},
            {'O','O','O'}
        };
        solution.solve(board6);
        assertArrayEquals(expected6, board6);
    }
}