package problems.Greedy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HandOfStraightsTest {

    @Test
    void testIsNStraightHand() {
        HandOfStraights solution = new HandOfStraights();
        
        // Test case 1: Valid grouping
        int[] hand1 = {1,2,3,6,2,3,4,7,8};
        int groupSize1 = 3;
        assertTrue(solution.isNStraightHand(hand1, groupSize1));
        
        // Test case 2: Invalid grouping
        int[] hand2 = {1,2,3,4,5};
        int groupSize2 = 4;
        assertFalse(solution.isNStraightHand(hand2, groupSize2));
        
        // Test case 3: Single group
        int[] hand3 = {1,2,3};
        int groupSize3 = 3;
        assertTrue(solution.isNStraightHand(hand3, groupSize3));
        
        // Test case 4: Group size 1
        int[] hand4 = {1,1,2,2,3,3};
        int groupSize4 = 1;
        assertTrue(solution.isNStraightHand(hand4, groupSize4));
        
        // Test case 5: Missing consecutive numbers
        int[] hand5 = {1,2,4,5};
        int groupSize5 = 2;
        assertTrue(solution.isNStraightHand(hand5, groupSize5));
        
        // Test case 6: Duplicate handling
        int[] hand6 = {1,1,2,2,3,3};
        int groupSize6 = 3;
        assertTrue(solution.isNStraightHand(hand6, groupSize6));
        
        // Test case 7: Large numbers
        int[] hand7 = {8,10,12};
        int groupSize7 = 3;
        assertFalse(solution.isNStraightHand(hand7, groupSize7));
        
        // Test case 8: Length not divisible by group size
        int[] hand8 = {1,2,3,4,5};
        int groupSize8 = 3;
        assertFalse(solution.isNStraightHand(hand8, groupSize8));
    }
}