package problems.Tree;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
    InvertBinaryTreeTest.class,
    MaxDepthOfBinaryTreeTest.class,
    DiameterOfABinaryTreeTest.class,
    BalancedBinaryTreeTest.class,
    SameTreeTest.class,
    SubtreeOfAnotherTreeTest.class,
    BinaryTreeLevelOrderTraversalTest.class,
    ValidateBinarySearchTreeTest.class
})
public class TreeTestSuite {
}