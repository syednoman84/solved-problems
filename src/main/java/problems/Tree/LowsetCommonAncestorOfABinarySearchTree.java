public class LowsetCommonAncestorOfABinarySearchTree {
    /**
     * 235. Lowest Common Ancestor of a Binary Search Tree
     * Easy
     * 
     * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
     * 
     * According to the definition of LCA on Wikipedia: "The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself)."
     * 
     * Example 1:
     * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
     * Output: 6
     * Explanation: The LCA of nodes 2 and 8 is 6.
     * 
     * Example 2:
     * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
     * Output: 2
     * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
     * 
     * Example 3:
     * Input: root = [2,1], p = 2, q = 1
     * Output: 2
     * 
     * Constraints:
     * - The number of nodes in the tree is in the range [2, 105].
     * - -10^9 <= Node.val <= 10^9
     * - All Node.val are unique.
     * - p != q
     * - p and q will exist in the BST.
     * 
     * Approach:
     * - Recursion
     * - if root's val < p's val & q's val then reduce the problem to right subtree of root
     * - else if root's val > p's val & q's val then reduce the problem to left subtree of root
     * - else return root (if p's val or q's val equal to root's val or for p & q lies in different subtree of the root)
     * 
     * Time Complexity: O(logN)
     * Space Complexity: O(logN) recursive calls
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        int val = root.val;
        if(val < p.val && val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        else if(val > p.val && val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        return root;
    }

    public static void main(String[] args) {
        LowsetCommonAncestorOfABinarySearchTree solution = new LowsetCommonAncestorOfABinarySearchTree();
        
        // Test case 1: root = [2,1], p = 2, q = 1
        TreeNode root1 = new LowsetCommonAncestorOfABinarySearchTree().new TreeNode(2);
        TreeNode p1 = new LowsetCommonAncestorOfABinarySearchTree().new TreeNode(2);
        TreeNode q1 = new LowsetCommonAncestorOfABinarySearchTree().new TreeNode(1);
        root1.left = q1;
        TreeNode result1 = solution.lowestCommonAncestor(root1, p1, q1);
        boolean expected1 = true;
        boolean actual1 = result1 != null && result1.val == 2;
        String status1 = actual1 == expected1 ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: " + expected1 + ", Got: " + actual1 + " [" + status1 + "]");
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
