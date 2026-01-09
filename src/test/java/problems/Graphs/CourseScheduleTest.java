package problems.Graphs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CourseScheduleTest {

    @Test
    void testCanFinish() {
        CourseSchedule solution = new CourseSchedule();
        
        // Test case 1: Valid schedule - linear dependency
        int numCourses1 = 2;
        int[][] prerequisites1 = {{1,0}};
        assertTrue(solution.canFinish(numCourses1, prerequisites1));
        
        // Test case 2: Cycle detected
        int numCourses2 = 2;
        int[][] prerequisites2 = {{1,0},{0,1}};
        assertFalse(solution.canFinish(numCourses2, prerequisites2));
        
        // Test case 3: No prerequisites
        int numCourses3 = 3;
        int[][] prerequisites3 = {};
        assertTrue(solution.canFinish(numCourses3, prerequisites3));
        
        // Test case 4: Complex valid schedule
        int numCourses4 = 4;
        int[][] prerequisites4 = {{1,0},{2,0},{3,1},{3,2}};
        assertTrue(solution.canFinish(numCourses4, prerequisites4));
        
        // Test case 5: Complex cycle
        int numCourses5 = 3;
        int[][] prerequisites5 = {{0,1},{1,2},{2,0}};
        assertFalse(solution.canFinish(numCourses5, prerequisites5));
        
        // Test case 6: Single course
        int numCourses6 = 1;
        int[][] prerequisites6 = {};
        assertTrue(solution.canFinish(numCourses6, prerequisites6));
        
        // Test case 7: Self-dependency (should be invalid)
        int numCourses7 = 2;
        int[][] prerequisites7 = {{0,0}};
        assertFalse(solution.canFinish(numCourses7, prerequisites7));
    }
}