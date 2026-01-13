package problems.HeapPriorityQueue;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

/**
 * Test Suite for all HeapPriorityQueue problems
 * 
 * This suite runs all unit tests for the HeapPriorityQueue package, covering:
 * - Min and Max heap implementations
 * - Kth element problems
 * - Data stream processing
 * - Priority-based scheduling
 * - Design problems with heap optimization
 */
@Suite
@SelectClasses({
    KthLargestElementInAStreamTest.class,
    LastStoneWeightTest.class,
    KClosestPointsToOriginTest.class,
    KthLargestElementInAnArrayTest.class,
    TaskSchedulerTest.class,
    DesignTwitterTest.class,
    FindMedianFromDataStreamTest.class
})
public class HeapPriorityQueueTestSuite {
    // Test suite class - no additional code needed
    // JUnit 5 will automatically discover and run all specified test classes
}