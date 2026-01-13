package problems.MathGeometry;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SetMatrixZeroesTest {
    private final SetMatrixZeroes solution = new SetMatrixZeroes();

    @Test
    void testSetZeroes() {
        int[][] matrix1 = {{1,1,1},{1,0,1},{1,1,1}};
        solution.setZeroes(matrix1);
        assertArrayEquals(new int[][]{{1,0,1},{0,0,0},{1,0,1}}, matrix1);
        
        int[][] matrix2 = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        solution.setZeroes(matrix2);
        assertArrayEquals(new int[][]{{0,0,0,0},{0,4,5,0},{0,3,1,0}}, matrix2);
        
        int[][] matrix3 = {{1,2,3,4},{5,0,7,8},{0,10,11,12},{13,14,15,0}};
        solution.setZeroes(matrix3);
        assertArrayEquals(new int[][]{{0,0,3,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}}, matrix3);
    }
}