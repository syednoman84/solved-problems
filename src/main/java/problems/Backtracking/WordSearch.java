package problems.Backtracking;

/**
 * [79. Word Search](https://leetcode.com/problems/word-search/)
 * Medium
 *
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * Example 1:
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 *
 * Example 2:
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * Output: true
 *
 * Example 3:
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * Output: false
 *
 * Constraints:
 * - m == board.length
 * - n = board[i].length
 * - 1 <= m, n <= 6
 * - 1 <= word.length <= 15
 * - board and word consists of only lowercase and uppercase English letters.
 *
 * Approach:
 * Backtracking:
 * - 4 choices top, down, left & right moves
 * - mark the element we are accessing
 * - if we match the word, we get the ans
 *
 * Complexity Analysis:
 * - Time Complexity: O(4^N)
 * - Space Complexity: O(N)
 */
public class WordSearch {
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        visited = new boolean[rows][cols];
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(word.charAt(0) == board[i][j] && search(i, j, 0, word, board))
                    return true;
            }
        }
        return false;
    }
    
    public boolean search(int i, int j, int index, String word, char[][] board) {
        if(index == word.length())
            return true;
        
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || word.charAt(index) != board[i][j] || visited[i][j]) {
            return false;
        }
        
        visited[i][j] = true;
        
        if(
            search(i+1, j, index+1, word, board) ||
            search(i-1, j, index+1, word, board) ||
            search(i, j+1, index+1, word, board) ||
            search(i, j-1, index+1, word, board)
        ) {
            return true;
        }
        
        visited[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        WordSearch solution = new WordSearch();
        
        // Test case 1
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        boolean result = solution.exist(board, word);
        boolean expected = true;
        String status = result == expected ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: " + expected + ", Got: " + result + " [" + status + "]");
    }
}
