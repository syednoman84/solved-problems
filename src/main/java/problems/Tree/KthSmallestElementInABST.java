package problems.Tree;

public class KthSmallestElementInABST {
    /**
     * 230. Kth Smallest Element in a BST
     * Medium
     * 
     * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
     * 
     * Example 1:
     * Input: root = [3,1,4,null,2], k = 1
     * Output: 1
     * 
     * Example 2:
     * Input: root = [5,3,6,2,4,null,null,1], k = 3
     * Output: 3
     * 
     * Constraints:
     * - The number of nodes in the tree is n.
     * - 1 <= k <= n <= 10^4
     * - 0 <= Node.val <= 10^4
     * 
     * Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?
     * 
     * Approach:
     * - Recursion
     * - inorder traversal gives nodes in sorted order of a BST
     * - ans[] -> store the answer and k in the second index
     * - decrement ans[1] until it become 0
     *   - when it become zero, that node is the ans
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public int kthSmallest(TreeNode root, int k) {
        int[] ans = new int[2];
        ans[1] = k;
        inorder(root, ans);
        return ans[0];
    }
    
    private void inorder(TreeNode root, int[] ans) {
        if(root == null)
            return;
        inorder(root.left, ans);
        ans[1]--;
        if(ans[1] == 0)
            ans[0] = root.val;
        inorder(root.right, ans);
    }

    public static void main(String[] args) {
        KthSmallestElementInABST solution = new KthSmallestElementInABST();
        
        // Test case 1: root = [3,1,4,null,2], k = 1
        TreeNode root1 = new KthSmallestElementInABST().new TreeNode(3);
        root1.left = new KthSmallestElementInABST().new TreeNode(1);
        root1.right = new KthSmallestElementInABST().new TreeNode(4);
        root1.left.right = new KthSmallestElementInABST().new TreeNode(2);
        int result1 = solution.kthSmallest(root1, 1);
        int expected1 = 1;
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
