package problems.Stack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarFleetTest {
    private final CarFleet solution = new CarFleet();

    @Test
    void testCarFleet() {
        assertEquals(3, solution.carFleet(12, new int[]{10,8,0,5,3}, new int[]{2,4,1,1,3}));
        assertEquals(1, solution.carFleet(10, new int[]{3}, new int[]{3}));
        assertEquals(1, solution.carFleet(100, new int[]{0,2,4}, new int[]{4,2,1}));
        assertEquals(2, solution.carFleet(10, new int[]{6,8}, new int[]{3,2}));
    }
}