package problems.MiscDSA;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
    UnionFindTest.class,
    DijkstrasAlgorithmTest.class,
    BFSGraphTest.class,
    BellmanFordTest.class,
    KMPAlgorithmTest.class,
    SegmentTreeTest.class,
    FenwickTreeTest.class,
    FenwickTree2DTest.class
})
public class MiscDSATestSuite {
}