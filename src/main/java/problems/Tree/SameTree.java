public class SameTree {
    /**
     * 100. Same Tree
     * Easy
     * 
     * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
     * 
     * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
     * 
     * Example 1:
     * Input: p = [1,2,3], q = [1,2,3]
     * Output: true
     * 
     * Example 2:
     * Input: p = [1,2], q = [1,null,2]
     * Output: false
     * 
     * Example 3:
     * Input: p = [1,2,1], q = [1,1,2]
     * Output: false
     * 
     * Constraints:
     * - The number of nodes in both trees is in the range [0, 100].
     * - -104 <= Node.val <= 104
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(H), height of the tree
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        return (p.val == q.val) && (isSameTree(p.left, q.left)) && (isSameTree(p.right,q.right));
    }

    public static void main(String[] args) {
        SameTree solution = new SameTree();
        
        // Test case 1: p = [], q = []
        TreeNode p1 = null;
        TreeNode q1 = null;
        boolean result1 = solution.isSameTree(p1, q1);
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
