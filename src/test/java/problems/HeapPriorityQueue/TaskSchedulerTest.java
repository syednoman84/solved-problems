package problems.HeapPriorityQueue;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskSchedulerTest {

    @Test
    void testLeastInterval() {
        TaskScheduler solution = new TaskScheduler();
        
        // Test case 1: Standard example
        char[] tasks1 = {'A','A','A','B','B','B'};
        assertEquals(8, solution.leastInterval(tasks1, 2));
        
        // Test case 2: No cooldown
        char[] tasks2 = {'A','A','A','B','B','B'};
        assertEquals(6, solution.leastInterval(tasks2, 0));
        
        // Test case 3: Long cooldown
        char[] tasks3 = {'A','A','A','A','A','A','B','C','D','E','F','G'};
        assertEquals(16, solution.leastInterval(tasks3, 2));
        
        // Test case 4: Single task type
        char[] tasks4 = {'A','A','A','A'};
        assertEquals(10, solution.leastInterval(tasks4, 2));
        
        // Test case 5: Many different tasks
        char[] tasks5 = {'A','B','C','D','E','F','G','H','I','J','K'};
        assertEquals(11, solution.leastInterval(tasks5, 2));
        
        // Test case 6: Equal frequency tasks
        char[] tasks6 = {'A','A','B','B','C','C'};
        assertEquals(6, solution.leastInterval(tasks6, 2));
        
        // Test case 7: Single task
        char[] tasks7 = {'A'};
        assertEquals(1, solution.leastInterval(tasks7, 2));
        
        // Test case 8: High cooldown with few tasks
        char[] tasks8 = {'A','A'};
        assertEquals(4, solution.leastInterval(tasks8, 2));
    }
}