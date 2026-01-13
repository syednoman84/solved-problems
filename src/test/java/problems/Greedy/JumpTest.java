package problems.Greedy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JumpTest {

    @Test
    void testCanJump() {
        Jump solution = new Jump();
        
        // Test case 1: Can reach end
        int[] nums1 = {2,3,1,1,4};
        assertTrue(solution.canJump(nums1));
        
        // Test case 2: Cannot reach end due to zero
        int[] nums2 = {3,2,1,0,4};
        assertFalse(solution.canJump(nums2));
        
        // Test case 3: Single element
        int[] nums3 = {0};
        assertTrue(solution.canJump(nums3));
        
        // Test case 4: Large jump at start
        int[] nums4 = {5,0,0,0,0};
        assertTrue(solution.canJump(nums4));
        
        // Test case 5: Zero at start (length > 1)
        int[] nums5 = {0,1};
        assertFalse(solution.canJump(nums5));
        
        // Test case 6: All ones
        int[] nums6 = {1,1,1,1};
        assertTrue(solution.canJump(nums6));
        
        // Test case 7: Decreasing pattern
        int[] nums7 = {4,3,2,1,0};
        assertTrue(solution.canJump(nums7));
        
        // Test case 8: Early zero block
        int[] nums8 = {1,0,1,0};
        assertFalse(solution.canJump(nums8));
    }
}