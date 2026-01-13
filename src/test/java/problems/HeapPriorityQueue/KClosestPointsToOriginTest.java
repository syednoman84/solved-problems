package problems.HeapPriorityQueue;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class KClosestPointsToOriginTest {

    @Test
    void testKClosest() {
        KClosestPointsToOrigin solution = new KClosestPointsToOrigin();
        
        // Test case 1: Standard example
        int[][] points1 = {{1,3},{-2,2}};
        int[][] result1 = solution.kClosest(points1, 1);
        assertEquals(1, result1.length);
        assertTrue(Arrays.equals(new int[]{-2,2}, result1[0]));
        
        // Test case 2: Multiple points
        int[][] points2 = {{3,3},{5,-1},{-2,4}};
        int[][] result2 = solution.kClosest(points2, 2);
        assertEquals(2, result2.length);
        Set<String> expected2 = new HashSet<>();
        expected2.add("3,3");
        expected2.add("-2,4");
        Set<String> actual2 = new HashSet<>();
        for(int[] point : result2) {
            actual2.add(point[0] + "," + point[1]);
        }
        assertEquals(expected2, actual2);
        
        // Test case 3: Origin point
        int[][] points3 = {{0,1},{1,0},{2,0},{0,2},{0,0}};
        int[][] result3 = solution.kClosest(points3, 3);
        assertEquals(3, result3.length);
        
        // Test case 4: All points
        int[][] points4 = {{1,1},{2,2}};
        int[][] result4 = solution.kClosest(points4, 2);
        assertEquals(2, result4.length);
        
        // Test case 5: Single point
        int[][] points5 = {{0,3}};
        int[][] result5 = solution.kClosest(points5, 1);
        assertEquals(1, result5.length);
        assertTrue(Arrays.equals(new int[]{0,3}, result5[0]));
        
        // Test case 6: Negative coordinates
        int[][] points6 = {{-5,4},{-6,-5},{4,6}};
        int[][] result6 = solution.kClosest(points6, 2);
        assertEquals(2, result6.length);
    }
}