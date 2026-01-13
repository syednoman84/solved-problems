package problems.Tree;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SubtreeOfAnotherTreeTest {
    private final SubtreeOfAnotherTree solution = new SubtreeOfAnotherTree();

    @Test
    void testIsSubtree() {
        SubtreeOfAnotherTree.TreeNode root = solution.new TreeNode(3);
        root.left = solution.new TreeNode(4);
        root.right = solution.new TreeNode(5);
        root.left.left = solution.new TreeNode(1);
        root.left.right = solution.new TreeNode(2);
        
        SubtreeOfAnotherTree.TreeNode subRoot = solution.new TreeNode(4);
        subRoot.left = solution.new TreeNode(1);
        subRoot.right = solution.new TreeNode(2);
        assertTrue(solution.isSubtree(root, subRoot));
        
        SubtreeOfAnotherTree.TreeNode single = solution.new TreeNode(1);
        SubtreeOfAnotherTree.TreeNode subSingle = solution.new TreeNode(1);
        assertTrue(solution.isSubtree(single, subSingle));
        
        assertFalse(solution.isSubtree(single, solution.new TreeNode(2)));
    }
}