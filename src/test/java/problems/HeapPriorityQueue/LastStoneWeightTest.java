package problems.HeapPriorityQueue;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LastStoneWeightTest {

    @Test
    void testLastStoneWeight() {
        LastStoneWeight solution = new LastStoneWeight();
        
        // Test case 1: Standard example
        int[] stones1 = {2,7,4,1,8,1};
        assertEquals(1, solution.lastStoneWeight(stones1));
        
        // Test case 2: Single stone
        int[] stones2 = {1};
        assertEquals(1, solution.lastStoneWeight(stones2));
        
        // Test case 3: Two equal stones
        int[] stones3 = {3,3};
        assertEquals(0, solution.lastStoneWeight(stones3));
        
        // Test case 4: All stones destroyed
        int[] stones4 = {2,2,3,3};
        assertEquals(0, solution.lastStoneWeight(stones4));
        
        // Test case 5: Decreasing order
        int[] stones5 = {10,4,2,10};
        assertEquals(2, solution.lastStoneWeight(stones5));
        
        // Test case 6: Large difference
        int[] stones6 = {20,3,2,1};
        assertEquals(14, solution.lastStoneWeight(stones6));
        
        // Test case 7: Multiple same weights
        int[] stones7 = {5,5,5,5};
        assertEquals(0, solution.lastStoneWeight(stones7));
    }
}