package problems.MathGeometry;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DetectSquaresTest {

    @Test
    void testDetectSquares() {
        DetectSquares ds = new DetectSquares();
        ds.add(new int[]{3, 10});
        ds.add(new int[]{11, 2});
        ds.add(new int[]{3, 2});
        assertEquals(1, ds.count(new int[]{11, 10}));
        assertEquals(0, ds.count(new int[]{14, 8}));
        ds.add(new int[]{11, 2});
        assertEquals(2, ds.count(new int[]{11, 10}));
    }
}