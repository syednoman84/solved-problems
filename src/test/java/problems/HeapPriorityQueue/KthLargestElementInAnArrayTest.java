package problems.HeapPriorityQueue;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class KthLargestElementInAnArrayTest {

    @Test
    void testFindKthLargest() {
        KthLargestElementInAnArray solution = new KthLargestElementInAnArray();
        
        // Test case 1: Standard example
        int[] nums1 = {3,2,1,5,6,4};
        assertEquals(5, solution.findKthLargest(nums1, 2));
        
        // Test case 2: Another example
        int[] nums2 = {3,2,3,1,2,4,5,5,6};
        assertEquals(4, solution.findKthLargest(nums2, 4));
        
        // Test case 3: k=1 (largest element)
        int[] nums3 = {7,10,4,3,20,15};
        assertEquals(20, solution.findKthLargest(nums3, 1));
        
        // Test case 4: k=length (smallest element)
        int[] nums4 = {1,2,3,4,5};
        assertEquals(1, solution.findKthLargest(nums4, 5));
        
        // Test case 5: Single element
        int[] nums5 = {1};
        assertEquals(1, solution.findKthLargest(nums5, 1));
        
        // Test case 6: Duplicates
        int[] nums6 = {3,3,3,3,3,3,3,3,3};
        assertEquals(3, solution.findKthLargest(nums6, 5));
        
        // Test case 7: Negative numbers
        int[] nums7 = {-1,2,0};
        assertEquals(0, solution.findKthLargest(nums7, 2));
        
        // Test case 8: All same except one
        int[] nums8 = {2,1,1,1,1};
        assertEquals(2, solution.findKthLargest(nums8, 1));
        assertEquals(1, solution.findKthLargest(nums8, 2));
    }
}