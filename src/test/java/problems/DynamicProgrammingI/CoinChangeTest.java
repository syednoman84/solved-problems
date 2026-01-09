package problems.DynamicProgrammingI;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CoinChangeTest {
    private final CoinChange solution = new CoinChange();

    @Test
    void testCoinChange() {
        assertEquals(3, solution.coinChange(new int[]{1,2,5}, 11));
        assertEquals(-1, solution.coinChange(new int[]{2}, 3));
        assertEquals(0, solution.coinChange(new int[]{1}, 0));
        assertEquals(1, solution.coinChange(new int[]{1}, 1));
        assertEquals(2, solution.coinChange(new int[]{1,3,4}, 6));
    }
}