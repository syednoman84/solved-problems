package problems.MathGeometry;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Arrays;

class SpiralMatrixTest {
    private final SpiralMatrix solution = new SpiralMatrix();

    @Test
    void testSpiralOrder() {
        assertEquals(Arrays.asList(1,2,3,6,9,8,7,4,5), solution.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
        assertEquals(Arrays.asList(1,2,3,4,8,12,11,10,9,5,6,7), solution.spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}));
        assertEquals(Arrays.asList(1), solution.spiralOrder(new int[][]{{1}}));
        assertEquals(Arrays.asList(1,2,3), solution.spiralOrder(new int[][]{{1,2,3}}));
    }
}