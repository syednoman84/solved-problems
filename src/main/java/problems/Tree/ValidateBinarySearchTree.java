public class ValidateBinarySearchTree {
    /**
     * 98. Validate Binary Search Tree
     * Medium
     * 
     * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
     * 
     * A valid BST is defined as follows:
     * The left subtree of a node contains only nodes with keys less than the node's key.
     * The right subtree of a node contains only nodes with keys greater than the node's key.
     * Both the left and right subtrees must also be binary search trees.
     * 
     * Example 1:
     * Input: root = [2,1,3]
     * Output: true
     * 
     * Example 2:
     * Input: root = [5,1,4,null,null,3,6]
     * Output: false
     * Explanation: The root node's value is 5 but its right child's value is 4.
     * 
     * Constraints:
     * - The number of nodes in the tree is in the range [1, 10^4].
     * - -2^31 <= Node.val <= 2^31 - 1
     * 
     * Approach:
     * - Recursion
     * - for each node's val we check whether it's in the range (min, max)
     *   - if it fails we return false
     *   - recursively call left and right subtree
     * - start with (-infinity, +infinity)
     * - left child -> (min, node.val)
     * - right child -> (node.val, max)
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(H), H : height of tree, recursive calls
     */
    public boolean isValidBST(TreeNode root) {
        Long min = Long.MIN_VALUE;
        Long max = Long.MAX_VALUE;
        
        return helper(root, min, max);
        
    }
    
    private boolean helper(TreeNode root, Long min, Long max) {
        if(root == null)
            return true;
        Long val = (long) root.val;
        if(val <= min || val >= max)
            return false;
        return helper(root.left, min, val) && helper(root.right, val, max);
    }

    public static void main(String[] args) {
        ValidateBinarySearchTree solution = new ValidateBinarySearchTree();
        
        // Test case 1: root = [2,1,3]
        TreeNode root1 = new ValidateBinarySearchTree().new TreeNode(2);
        root1.left = new ValidateBinarySearchTree().new TreeNode(1);
        root1.right = new ValidateBinarySearchTree().new TreeNode(3);
        boolean result1 = solution.isValidBST(root1);
        boolean expected1 = true;
        String status1 = result1 == expected1 ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: " + expected1 + ", Got: " + result1 + " [" + status1 + "]");
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
