package problems.BinarySearch;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SearchIn2DMatrixTest {
    private final SearchIn2DMatrix solution = new SearchIn2DMatrix();

    @Test
    void testSearchMatrix() {
        int[][] matrix1 = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        assertTrue(solution.searchMatrix(matrix1, 3));
        assertFalse(solution.searchMatrix(matrix1, 13));
        
        int[][] matrix2 = {{1}};
        assertTrue(solution.searchMatrix(matrix2, 1));
        assertFalse(solution.searchMatrix(matrix2, 2));
        
        int[][] matrix3 = {{1,4,7,11},{2,5,8,12},{3,6,9,16}};
        assertTrue(solution.searchMatrix(matrix3, 5));
    }
}