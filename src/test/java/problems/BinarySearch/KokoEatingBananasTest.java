package problems.BinarySearch;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class KokoEatingBananasTest {
    private final KokoEatingBananas solution = new KokoEatingBananas();

    @Test
    void testMinEatingSpeed() {
        assertEquals(4, solution.minEatingSpeed(new int[]{3,6,7,11}, 8));
        assertEquals(30, solution.minEatingSpeed(new int[]{30,11,23,4,20}, 5));
        assertEquals(23, solution.minEatingSpeed(new int[]{30,11,23,4,20}, 6));
        assertEquals(1, solution.minEatingSpeed(new int[]{1,1,1,1}, 4));
        assertEquals(1, solution.minEatingSpeed(new int[]{1,1,1,1}, 3));
    }
}