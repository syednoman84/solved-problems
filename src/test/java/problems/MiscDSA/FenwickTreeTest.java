package problems.MiscDSA;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FenwickTreeTest {

    @Test
    void testFenwickTree() {
        int[] nums = {1, 2, 3, 4, 5};
        FenwickTree ft = new FenwickTree(5, nums);
        assertEquals(6, ft.sumRange(0, 2));
        assertEquals(15, ft.sumRange(0, 4));
        ft.update(1, 10);
        assertEquals(14, ft.sumRange(0, 2));
    }
}