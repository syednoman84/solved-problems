package problems.TwoPointer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Arrays;

class ThreeSumTest {
    private final ThreeSum solution = new ThreeSum();

    @Test
    void testThreeSum() {
        List<List<Integer>> result1 = solution.threeSum(new int[]{-1,0,1,2,-1,-4});
        assertEquals(2, result1.size());
        assertTrue(result1.contains(Arrays.asList(-1,-1,2)));
        assertTrue(result1.contains(Arrays.asList(-1,0,1)));
        
        assertTrue(solution.threeSum(new int[]{}).isEmpty());
        assertTrue(solution.threeSum(new int[]{0}).isEmpty());
        
        List<List<Integer>> result2 = solution.threeSum(new int[]{0,0,0});
        assertEquals(1, result2.size());
        assertTrue(result2.contains(Arrays.asList(0,0,0)));
    }
}