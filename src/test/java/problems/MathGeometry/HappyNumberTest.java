package problems.MathGeometry;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HappyNumberTest {
    private final HappyNumber solution = new HappyNumber();

    @Test
    void testIsHappy() {
        assertTrue(solution.isHappy(19));
        assertFalse(solution.isHappy(2));
        assertTrue(solution.isHappy(1));
        assertTrue(solution.isHappy(7));
    }
}