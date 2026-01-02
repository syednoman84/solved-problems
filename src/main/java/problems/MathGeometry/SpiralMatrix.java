import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        int sr = 0, sc = 0;
        int i = sr, j = sc;
        while (sc <= n || sr <= m) {

            // 1st row
            while (j <= n) {
                res.add(matrix[i][j]);
                j++;
            }
            sr++;
            j = n;
            i = sr;

            // condition
            if (i > m || j > n) {
                break;
            }
            // last column
            while (i <= m) {
                res.add(matrix[i][j]);
                i++;
            }
            n--;
            i = m;
            j = n;

            if (i > m || j > n) {
                break;
            }

            // last row
            while (j >= sc) {
                res.add(matrix[i][j]);
                j--;
            }
            m--;
            j = sc;
            i = m;

            if (i > m || j > n) {
                break;
            }
            // 1st column
            while (i >= sr) {
                res.add(matrix[i][j]);
                i--;
            }
            sc++;
            i = sr;
            j = sc;

            if (i > m || j > n) {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SpiralMatrix solution = new SpiralMatrix();
        
        // Test case 1: matrix = [[1,2,3],[4,5,6],[7,8,9]]
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> result1 = solution.spiralOrder(matrix1);
        String expected1 = "[1, 2, 3, 6, 9, 8, 7, 4, 5]";
        String actual1 = result1.toString();
        String status1 = actual1.equals(expected1) ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: " + expected1 + ", Got: " + actual1 + " [" + status1 + "]");
    }
}
