package problems.Tree;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SameTreeTest {
    private final SameTree solution = new SameTree();

    @Test
    void testIsSameTree() {
        assertTrue(solution.isSameTree(null, null));
        
        SameTree.TreeNode p = solution.new TreeNode(1);
        p.left = solution.new TreeNode(2);
        p.right = solution.new TreeNode(3);
        SameTree.TreeNode q = solution.new TreeNode(1);
        q.left = solution.new TreeNode(2);
        q.right = solution.new TreeNode(3);
        assertTrue(solution.isSameTree(p, q));
        
        SameTree.TreeNode p2 = solution.new TreeNode(1);
        p2.left = solution.new TreeNode(2);
        SameTree.TreeNode q2 = solution.new TreeNode(1);
        q2.right = solution.new TreeNode(2);
        assertFalse(solution.isSameTree(p2, q2));
    }
}