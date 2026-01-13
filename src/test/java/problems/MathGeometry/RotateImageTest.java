package problems.MathGeometry;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RotateImageTest {
    private final RotateImage solution = new RotateImage();

    @Test
    void testRotate() {
        int[][] matrix1 = {{1,2,3},{4,5,6},{7,8,9}};
        solution.rotate(matrix1);
        assertArrayEquals(new int[][]{{7,4,1},{8,5,2},{9,6,3}}, matrix1);
        
        int[][] matrix2 = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        solution.rotate(matrix2);
        assertArrayEquals(new int[][]{{15,13,2,5},{14,3,4,1},{12,6,8,9},{16,7,10,11}}, matrix2);
        
        int[][] matrix3 = {{1}};
        solution.rotate(matrix3);
        assertArrayEquals(new int[][]{{1}}, matrix3);
    }
}