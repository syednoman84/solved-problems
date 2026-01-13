package problems.Tree;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Arrays;

class BinaryTreeLevelOrderTraversalTest {
    private final BinaryTreeLevelOrderTraversal solution = new BinaryTreeLevelOrderTraversal();

    @Test
    void testLevelOrder() {
        assertTrue(solution.levelOrder(null).isEmpty());
        
        BinaryTreeLevelOrderTraversal.TreeNode root = solution.new TreeNode(3);
        root.left = solution.new TreeNode(9);
        root.right = solution.new TreeNode(20);
        root.right.left = solution.new TreeNode(15);
        root.right.right = solution.new TreeNode(7);
        List<List<Integer>> result = solution.levelOrder(root);
        assertEquals(3, result.size());
        assertEquals(Arrays.asList(3), result.get(0));
        assertEquals(Arrays.asList(9, 20), result.get(1));
        assertEquals(Arrays.asList(15, 7), result.get(2));
        
        BinaryTreeLevelOrderTraversal.TreeNode single = solution.new TreeNode(1);
        List<List<Integer>> result2 = solution.levelOrder(single);
        assertEquals(1, result2.size());
        assertEquals(Arrays.asList(1), result2.get(0));
    }
}