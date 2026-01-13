package problems.Tree;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InvertBinaryTreeTest {
    private final InvertBinaryTree solution = new InvertBinaryTree();

    @Test
    void testInvertTree() {
        assertNull(solution.invertTree(null));
        
        InvertBinaryTree.TreeNode root = solution.new TreeNode(4);
        root.left = solution.new TreeNode(2);
        root.right = solution.new TreeNode(7);
        InvertBinaryTree.TreeNode result = solution.invertTree(root);
        assertEquals(4, result.val);
        assertEquals(7, result.left.val);
        assertEquals(2, result.right.val);
        
        InvertBinaryTree.TreeNode single = solution.new TreeNode(1);
        InvertBinaryTree.TreeNode result2 = solution.invertTree(single);
        assertEquals(1, result2.val);
    }
}