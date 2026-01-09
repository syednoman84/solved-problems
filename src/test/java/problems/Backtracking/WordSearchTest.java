package problems.Backtracking;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WordSearchTest {
    private final WordSearch solution = new WordSearch();

    @Test
    void testExist() {
        char[][] board1 = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        assertTrue(solution.exist(board1, "ABCCED"));
        assertTrue(solution.exist(board1, "SEE"));
        assertFalse(solution.exist(board1, "ABCB"));
        
        char[][] board2 = {{'A'}};
        assertTrue(solution.exist(board2, "A"));
        assertFalse(solution.exist(board2, "AB"));
    }
}