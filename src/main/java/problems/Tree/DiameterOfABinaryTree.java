package problems.Tree;

public class DiameterOfABinaryTree {
    /**
     * 543. Diameter of Binary Tree
     * Easy
     * 
     * Given the root of a binary tree, return the length of the diameter of the tree.
     * 
     * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
     * 
     * The length of a path between two nodes is represented by the number of edges between them.
     * 
     * Example 1:
     * Input: root = [1,2,3,4,5]
     * Output: 3
     * Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
     * 
     * Example 2:
     * Input: root = [1,2]
     * Output: 1
     * 
     * Constraints:
     * - The number of nodes in the tree is in the range [1, 104].
     * - -100 <= Node.val <= 100
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(logN), recursive call stacks
     */
    int maxDiameter;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter = 0;
        height(root);
        return maxDiameter;
    }
    
    public int height(TreeNode root) {
        if(root == null)
            return -1;
        int left = height(root.left);
        int right = height(root.right);
        int h = 1 + Math.max(left, right);
        maxDiameter = Math.max(maxDiameter, left + right + 2);
        return h;
    }

    public static void main(String[] args) {
        DiameterOfABinaryTree solution = new DiameterOfABinaryTree();
        
        // Test case 1: root = [1,2]
        TreeNode root1 = new DiameterOfABinaryTree().new TreeNode(1);
        root1.left = new DiameterOfABinaryTree().new TreeNode(2);
        int result1 = solution.diameterOfBinaryTree(root1);
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
