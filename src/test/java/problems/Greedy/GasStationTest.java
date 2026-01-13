package problems.Greedy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GasStationTest {

    @Test
    void testCanCompleteCircuit() {
        GasStation solution = new GasStation();
        
        // Test case 1: Valid circuit from index 3
        int[] gas1 = {1,2,3,4,5};
        int[] cost1 = {3,4,5,1,2};
        assertEquals(3, solution.canCompleteCircuit(gas1, cost1));
        
        // Test case 2: Impossible circuit
        int[] gas2 = {2,3,4};
        int[] cost2 = {3,4,3};
        assertEquals(-1, solution.canCompleteCircuit(gas2, cost2));
        
        // Test case 3: Single station
        int[] gas3 = {5};
        int[] cost3 = {4};
        assertEquals(0, solution.canCompleteCircuit(gas3, cost3));
        
        // Test case 4: Single station impossible
        int[] gas4 = {2};
        int[] cost4 = {3};
        assertEquals(-1, solution.canCompleteCircuit(gas4, cost4));
        
        // Test case 5: Start from beginning
        int[] gas5 = {3,1,1};
        int[] cost5 = {1,2,2};
        assertEquals(0, solution.canCompleteCircuit(gas5, cost5));
        
        // Test case 6: Exact balance
        int[] gas6 = {2,2,2};
        int[] cost6 = {2,2,2};
        assertEquals(0, solution.canCompleteCircuit(gas6, cost6));
        
        // Test case 7: Multiple resets needed
        int[] gas7 = {1,1,3,1};
        int[] cost7 = {2,2,1,1};
        assertEquals(2, solution.canCompleteCircuit(gas7, cost7));
    }
}