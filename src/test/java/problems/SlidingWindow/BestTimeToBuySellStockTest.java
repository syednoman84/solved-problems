package problems.SlidingWindow;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BestTimeToBuySellStockTest {
    private final BestTimeToBuySellStock solution = new BestTimeToBuySellStock();

    @Test
    void testMaxProfit() {
        assertEquals(5, solution.maxProfit(new int[]{7,1,5,3,6,4}));
        assertEquals(0, solution.maxProfit(new int[]{7,6,4,3,1}));
        assertEquals(0, solution.maxProfit(new int[]{1}));
        assertEquals(4, solution.maxProfit(new int[]{1,5}));
    }
}