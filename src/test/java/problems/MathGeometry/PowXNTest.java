package problems.MathGeometry;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PowXNTest {
    private final PowXN solution = new PowXN();

    @Test
    void testMyPow() {
        assertEquals(1024.0, solution.myPow(2.0, 10), 0.00001);
        assertEquals(9.261, solution.myPow(2.1, 3), 0.001);
        assertEquals(0.25, solution.myPow(2.0, -2), 0.00001);
        assertEquals(1.0, solution.myPow(1.0, 2147483647), 0.00001);
    }
}