package problems.ArraysHashing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class TopKElementsTest {
    private final TopKElements solution = new TopKElements();

    @Test
    void testTopKFrequent() {
        int[] result1 = solution.topKFrequent(new int[]{1,1,1,2,2,3}, 2);
        Arrays.sort(result1);
        assertArrayEquals(new int[]{1,2}, result1);
        
        int[] result2 = solution.topKFrequent(new int[]{1}, 1);
        assertArrayEquals(new int[]{1}, result2);
        
        int[] result3 = solution.topKFrequent(new int[]{4,1,-1,2,-1,2,3}, 2);
        Arrays.sort(result3);
        assertArrayEquals(new int[]{-1,2}, result3);
        
        int[] result4 = solution.topKFrequent(new int[]{3,0,1,0}, 1);
        assertArrayEquals(new int[]{0}, result4);
    }
}