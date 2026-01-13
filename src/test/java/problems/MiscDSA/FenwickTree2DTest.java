package problems.MiscDSA;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FenwickTree2DTest {

    @Test
    void testFenwickTree2D() {
        int[][] arr = {{1, 2}, {3, 4}};
        FenwickTree2D ft = new FenwickTree2D(arr);
        assertEquals(10, ft.rangeSum(1, 1, 2, 2));
        assertEquals(1, ft.rangeSum(1, 1, 1, 1));
        assertEquals(4, ft.rangeSum(1, 1, 2, 1));
    }
}