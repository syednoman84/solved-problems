package problems.HeapPriorityQueue;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class KthLargestElementInAStreamTest {

    @Test
    void testKthLargestElementInAStream() {
        // Test case 1: Standard example
        kthLargestElementInAStream kthLargest1 = new kthLargestElementInAStream(3, new int[]{4, 5, 8, 2});
        assertEquals(4, kthLargest1.add(3));
        assertEquals(5, kthLargest1.add(5));
        assertEquals(5, kthLargest1.add(10));
        assertEquals(8, kthLargest1.add(9));
        assertEquals(8, kthLargest1.add(4));
        
        // Test case 2: Single element k=1
        kthLargestElementInAStream kthLargest2 = new kthLargestElementInAStream(1, new int[]{});
        assertEquals(-3, kthLargest2.add(-3));
        assertEquals(-2, kthLargest2.add(-2));
        assertEquals(-1, kthLargest2.add(-1));
        assertEquals(1, kthLargest2.add(1));
        
        // Test case 3: Empty initial array
        kthLargestElementInAStream kthLargest3 = new kthLargestElementInAStream(2, new int[]{});
        assertEquals(-1, kthLargest3.add(-1));
        assertEquals(-1, kthLargest3.add(1));
        assertEquals(1, kthLargest3.add(3));
        
        // Test case 4: Large k value
        kthLargestElementInAStream kthLargest4 = new kthLargestElementInAStream(4, new int[]{7, 10, 9, 3, 20, 15});
        assertEquals(9, kthLargest4.add(3));
        assertEquals(9, kthLargest4.add(2));
        assertEquals(9, kthLargest4.add(1));
        assertEquals(9, kthLargest4.add(5));
        assertEquals(9, kthLargest4.add(8));
    }
}