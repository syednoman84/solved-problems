package problems.Graphs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class CourseScheduleIITest {

    @Test
    void testFindOrder() {
        CourseScheduleII solution = new CourseScheduleII();
        
        // Test case 1: Simple linear dependency
        int numCourses1 = 2;
        int[][] prerequisites1 = {{1,0}};
        int[] result1 = solution.findOrder(numCourses1, prerequisites1);
        assertEquals(2, result1.length);
        assertTrue(Arrays.equals(new int[]{0,1}, result1));
        
        // Test case 2: Complex valid schedule
        int numCourses2 = 4;
        int[][] prerequisites2 = {{1,0},{2,0},{3,1},{3,2}};
        int[] result2 = solution.findOrder(numCourses2, prerequisites2);
        assertEquals(4, result2.length);
        // Verify valid topological order
        assertTrue(isValidOrder(result2, prerequisites2));
        
        // Test case 3: No prerequisites
        int numCourses3 = 1;
        int[][] prerequisites3 = {};
        int[] result3 = solution.findOrder(numCourses3, prerequisites3);
        assertEquals(1, result3.length);
        assertEquals(0, result3[0]);
        
        // Test case 4: Cycle detected - should return empty array
        int numCourses4 = 2;
        int[][] prerequisites4 = {{1,0},{0,1}};
        int[] result4 = solution.findOrder(numCourses4, prerequisites4);
        assertEquals(0, result4.length);
        
        // Test case 5: Multiple valid orders
        int numCourses5 = 3;
        int[][] prerequisites5 = {{1,0}};
        int[] result5 = solution.findOrder(numCourses5, prerequisites5);
        assertEquals(3, result5.length);
        assertTrue(isValidOrder(result5, prerequisites5));
        
        // Test case 6: Complex cycle
        int numCourses6 = 3;
        int[][] prerequisites6 = {{0,1},{1,2},{2,0}};
        int[] result6 = solution.findOrder(numCourses6, prerequisites6);
        assertEquals(0, result6.length);
    }
    
    private boolean isValidOrder(int[] order, int[][] prerequisites) {
        Set<Integer> completed = new HashSet<>();
        for (int course : order) {
            // Check if all prerequisites are completed
            for (int[] prereq : prerequisites) {
                if (prereq[0] == course && !completed.contains(prereq[1])) {
                    return false;
                }
            }
            completed.add(course);
        }
        return true;
    }
}