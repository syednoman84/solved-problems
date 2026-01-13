package problems.Tree;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BalancedBinaryTreeTest {
    private final BalancedBinaryTree solution = new BalancedBinaryTree();

    @Test
    void testIsBalanced() {
        assertTrue(solution.isBalanced(null));
        
        BalancedBinaryTree.TreeNode root = solution.new TreeNode(3);
        root.left = solution.new TreeNode(9);
        root.right = solution.new TreeNode(20);
        root.right.left = solution.new TreeNode(15);
        root.right.right = solution.new TreeNode(7);
        assertTrue(solution.isBalanced(root));
        
        BalancedBinaryTree.TreeNode unbalanced = solution.new TreeNode(1);
        unbalanced.left = solution.new TreeNode(2);
        unbalanced.left.left = solution.new TreeNode(3);
        assertFalse(solution.isBalanced(unbalanced));
    }
}