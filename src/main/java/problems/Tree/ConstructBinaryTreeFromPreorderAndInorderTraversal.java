import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    /**
     * [105. Construct Binary Tree from Preorder and Inorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)
     * Medium
     * 
     * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
     * 
     * Example 1:
     * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
     * Output: [3,9,20,null,null,15,7]
     * 
     * Example 2:
     * Input: preorder = [-1], inorder = [-1]
     * Output: [-1]
     * 
     * Constraints:
     * - 1 <= preorder.length <= 3000
     * - inorder.length == preorder.length
     * - -3000 <= preorder[i], inorder[i] <= 3000
     * - preorder and inorder consist of unique values.
     * - Each value of inorder also appears in preorder.
     * - preorder is guaranteed to be the preorder traversal of the tree.
     * - inorder is guaranteed to be the inorder traversal of the tree.
     * 
     * Approach:
     * - start and end index
     * - inorderMap: mapping of inorder array with the index
     * - if start > end the return null
     * - root -> node with the preorder val with the preorder index
     * - root.left -> recursive call, in range (start, inorderMap.get(val)-1)
     * - root.right -> recursive call, in range (inorderMap.get(val)+1, end)
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    int preInd;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preInd = 0;
        int n = inorder.length;
        int startIndex = 0, endIndex = n-1;
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for(int i = 0; i < n; i++)
            inorderMap.put(inorder[i], i);
        return helper(preorder, inorder, startIndex, endIndex, inorderMap);
    }
    
    public TreeNode helper(int[] preorder, int[] inorder, int startIndex, int endIndex, Map<Integer, Integer> inorderMap) {
        if(startIndex > endIndex)
            return null;
        int val = preorder[preInd++];
        TreeNode root = new TreeNode(val);
        root.left = helper(preorder, inorder, startIndex, inorderMap.get(val)-1, inorderMap);
        root.right = helper(preorder, inorder, inorderMap.get(val)+1, endIndex, inorderMap);
        return root;
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndInorderTraversal solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
        
        // Test case 1: preorder = [-1], inorder = [-1]
        int[] preorder1 = {-1};
        int[] inorder1 = {-1};
        TreeNode result1 = solution.buildTree(preorder1, inorder1);
        boolean expected1 = true;
        boolean actual1 = result1 != null && result1.val == -1;
        String status1 = actual1 == expected1 ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: " + expected1 + ", Got: " + actual1 + " [" + status1 + "]");
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
