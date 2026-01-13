package problems.Tree;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DiameterOfABinaryTreeTest {
    private final DiameterOfABinaryTree solution = new DiameterOfABinaryTree();

    @Test
    void testDiameterOfBinaryTree() {
        DiameterOfABinaryTree.TreeNode root = solution.new TreeNode(1);
        root.left = solution.new TreeNode(2);
        root.right = solution.new TreeNode(3);
        root.left.left = solution.new TreeNode(4);
        root.left.right = solution.new TreeNode(5);
        assertEquals(3, solution.diameterOfBinaryTree(root));
        
        DiameterOfABinaryTree.TreeNode root2 = solution.new TreeNode(1);
        root2.left = solution.new TreeNode(2);
        assertEquals(1, solution.diameterOfBinaryTree(root2));
        
        DiameterOfABinaryTree.TreeNode single = solution.new TreeNode(1);
        assertEquals(0, solution.diameterOfBinaryTree(single));
    }
}