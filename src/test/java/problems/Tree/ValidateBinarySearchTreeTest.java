package problems.Tree;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ValidateBinarySearchTreeTest {
    private final ValidateBinarySearchTree solution = new ValidateBinarySearchTree();

    @Test
    void testIsValidBST() {
        ValidateBinarySearchTree.TreeNode root = solution.new TreeNode(2);
        root.left = solution.new TreeNode(1);
        root.right = solution.new TreeNode(3);
        assertTrue(solution.isValidBST(root));
        
        ValidateBinarySearchTree.TreeNode invalid = solution.new TreeNode(5);
        invalid.left = solution.new TreeNode(1);
        invalid.right = solution.new TreeNode(4);
        invalid.right.left = solution.new TreeNode(3);
        invalid.right.right = solution.new TreeNode(6);
        assertFalse(solution.isValidBST(invalid));
        
        ValidateBinarySearchTree.TreeNode single = solution.new TreeNode(1);
        assertTrue(solution.isValidBST(single));
    }
}