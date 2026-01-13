package problems.Greedy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JumpIITest {

    @Test
    void testJump() {
        JumpII solution = new JumpII();
        
        // Test case 1: Standard example
        int[] nums1 = {2,3,1,1,4};
        assertEquals(2, solution.jump(nums1));
        
        // Test case 2: Another example
        int[] nums2 = {2,3,0,1,4};
        assertEquals(2, solution.jump(nums2));
        
        // Test case 3: Single element
        int[] nums3 = {0};
        assertEquals(0, solution.jump(nums3));
        
        // Test case 4: Two elements
        int[] nums4 = {1,2};
        assertEquals(1, solution.jump(nums4));
        
        // Test case 5: Large jump at start
        int[] nums5 = {5,1,1,1,1};
        assertEquals(1, solution.jump(nums5));
        
        // Test case 6: All ones
        int[] nums6 = {1,1,1,1};
        assertEquals(3, solution.jump(nums6));
        
        // Test case 7: Optimal path selection
        int[] nums7 = {2,1,2,1,1};
        assertEquals(2, solution.jump(nums7));
        
        // Test case 8: Multiple optimal paths
        int[] nums8 = {3,2,1,1,4};
        assertEquals(2, solution.jump(nums8));
    }
}