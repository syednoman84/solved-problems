package problems.Greedy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MaximumSubarrayTest {

    @Test
    void testMaxSubArray() {
        MaximumSubarray solution = new MaximumSubarray();
        
        // Test case 1: Standard example
        int[] nums1 = {-2,1,-3,4,-1,2,1,-5,4};
        assertEquals(6, solution.maxSubArray(nums1));
        
        // Test case 2: Single element
        int[] nums2 = {1};
        assertEquals(1, solution.maxSubArray(nums2));
        
        // Test case 3: All positive
        int[] nums3 = {5,4,-1,7,8};
        assertEquals(23, solution.maxSubArray(nums3));
        
        // Test case 4: All negative
        int[] nums4 = {-3,-2,-1,-5};
        assertEquals(-1, solution.maxSubArray(nums4));
        
        // Test case 5: Mixed with zeros
        int[] nums5 = {-2,0,-1};
        assertEquals(0, solution.maxSubArray(nums5));
        
        // Test case 6: Large positive at end
        int[] nums6 = {-1,-2,100};
        assertEquals(100, solution.maxSubArray(nums6));
        
        // Test case 7: Alternating pattern
        int[] nums7 = {1,-1,1,-1,1};
        assertEquals(1, solution.maxSubArray(nums7));
    }
}