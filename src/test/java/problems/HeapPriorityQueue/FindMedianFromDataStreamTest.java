package problems.HeapPriorityQueue;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FindMedianFromDataStreamTest {

    @Test
    void testFindMedianFromDataStream() {
        // Test case 1: Standard example
        FindMedianFromDataStream medianFinder1 = new FindMedianFromDataStream();
        medianFinder1.addNum(1);
        assertEquals(1.0, medianFinder1.findMedian(), 0.00001);
        
        medianFinder1.addNum(2);
        assertEquals(1.5, medianFinder1.findMedian(), 0.00001);
        
        medianFinder1.addNum(3);
        assertEquals(2.0, medianFinder1.findMedian(), 0.00001);
        
        // Test case 2: Negative numbers
        FindMedianFromDataStream medianFinder2 = new FindMedianFromDataStream();
        medianFinder2.addNum(-1);
        assertEquals(-1.0, medianFinder2.findMedian(), 0.00001);
        
        medianFinder2.addNum(-2);
        assertEquals(-1.5, medianFinder2.findMedian(), 0.00001);
        
        medianFinder2.addNum(-3);
        assertEquals(-2.0, medianFinder2.findMedian(), 0.00001);
        
        // Test case 3: Mixed positive and negative
        FindMedianFromDataStream medianFinder3 = new FindMedianFromDataStream();
        medianFinder3.addNum(-1);
        medianFinder3.addNum(1);
        assertEquals(0.0, medianFinder3.findMedian(), 0.00001);
        
        medianFinder3.addNum(0);
        assertEquals(0.0, medianFinder3.findMedian(), 0.00001);
        
        // Test case 4: Duplicates
        FindMedianFromDataStream medianFinder4 = new FindMedianFromDataStream();
        medianFinder4.addNum(1);
        medianFinder4.addNum(1);
        assertEquals(1.0, medianFinder4.findMedian(), 0.00001);
        
        medianFinder4.addNum(1);
        assertEquals(1.0, medianFinder4.findMedian(), 0.00001);
        
        // Test case 5: Large numbers
        FindMedianFromDataStream medianFinder5 = new FindMedianFromDataStream();
        medianFinder5.addNum(100000);
        medianFinder5.addNum(-100000);
        assertEquals(0.0, medianFinder5.findMedian(), 0.00001);
        
        // Test case 6: Sequential addition
        FindMedianFromDataStream medianFinder6 = new FindMedianFromDataStream();
        for(int i = 1; i <= 5; i++) {
            medianFinder6.addNum(i);
        }
        assertEquals(3.0, medianFinder6.findMedian(), 0.00001);
    }
}