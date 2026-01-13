package problems.Tree;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MaxDepthOfBinaryTreeTest {
    private final MaxDepthOfBinaryTree solution = new MaxDepthOfBinaryTree();

    @Test
    void testMaxDepth() {
        assertEquals(0, solution.maxDepth(null));
        
        MaxDepthOfBinaryTree.TreeNode root = solution.new TreeNode(3);
        root.left = solution.new TreeNode(9);
        root.right = solution.new TreeNode(20);
        root.right.left = solution.new TreeNode(15);
        root.right.right = solution.new TreeNode(7);
        assertEquals(3, solution.maxDepth(root));
        
        MaxDepthOfBinaryTree.TreeNode single = solution.new TreeNode(1);
        assertEquals(1, solution.maxDepth(single));
    }
}