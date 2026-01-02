package problems.MathGeometry;

/**
 * [48. Rotate Image](https://leetcode.com/problems/rotate-image/)
 * Medium
 *
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix and do the rotation.
 *
 * Example 1:
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[7,4,1],[8,5,2],[9,6,3]]
 *
 * Example 2:
 * Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 *
 * Constraints:
 * - n == matrix.length == matrix[i].length
 * - 1 <= n <= 20
 * - -1000 <= matrix[i][j] <= 1000
 *
 * Approach:
 * - Rotate = Transpose + Reverse
 * - First transpose the matrix (swap elements across diagonal)
 * - Then reverse each row
 *
 * Complexity Analysis:
 * - Time Complexity: O(n), n : number of elements in the matrix
 * - Space Complexity: O(1)
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        for(int[] nums : matrix) {
            reverse(nums);
        }
    }
    
    private void transpose(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = i + 1; j < matrix.length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
    
    private void reverse(int[] nums) {
        for(int i = 0, j = nums.length-1; i < j; i++, j--) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    public static void main(String[] args) {
        RotateImage solution = new RotateImage();
        
        // Test case 1: matrix = [[1,2,3],[4,5,6],[7,8,9]]
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        solution.rotate(matrix1);
        boolean expected1 = true;
        boolean actual1 = matrix1[0][0] == 7 && matrix1[0][1] == 4 && matrix1[0][2] == 1;
        String status1 = actual1 == expected1 ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: " + expected1 + ", Got: " + actual1 + " [" + status1 + "]");
    }
}
