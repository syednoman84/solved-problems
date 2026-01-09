package problems.Graphs;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

/**
 * Test Suite for all Graphs problems
 * 
 * This suite runs all unit tests for the Graphs package, covering:
 * - DFS/BFS algorithms
 * - Topological sorting
 * - Union-Find data structure
 * - Graph traversal and connectivity
 * - Island and grid problems
 * - Shortest path algorithms
 */
@Suite
@SelectClasses({
    NumberOfIslandsTest.class,
    CloneGraphTest.class,
    MaxAreaOfIslandTest.class,
    PacificAtlanticWaterFlowTest.class,
    SurroundedRegionsTest.class,
    RottenOrangesTest.class,
    WallsAndGatesTest.class,
    CourseScheduleTest.class,
    CourseScheduleIITest.class,
    RedundantConnectionTest.class,
    NumberOfConnectedComponentsInAnUndirectedGraphTest.class,
    GraphValidTreeTest.class,
    WordLadderTest.class
})
public class GraphsTestSuite {
    // Test suite class - no additional code needed
    // JUnit 5 will automatically discover and run all specified test classes
}