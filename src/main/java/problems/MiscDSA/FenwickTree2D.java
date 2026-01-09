package problems.MiscDSA;

/**
 * 2D Fenwick Tree (Binary Indexed Tree) Data Structure
 *
 * A 2D Fenwick Tree extends the 1D version to handle 2D arrays.
 * It efficiently supports 2D range sum queries and point updates in O(log^2 n) time.
 *
 * Approach:
 * - Use LSOne(n) = n & (-n) for efficient bit manipulation
 * - Build the tree by accumulating values in 2D
 * - Query using 2D prefix sums with inclusion-exclusion principle
 * - Update by propagating changes in 2D
 *
 * Complexity Analysis:
 * - Build: O(n * m * log n * log m)
 * - Query: O(log^2 n)
 * - Update: O(log^2 n)
 * - Space Complexity: O(n * m)
 */
public class FenwickTree2D {
    int[][] ft;

    public FenwickTree2D(int[][] arr) {
        int n = arr.length, m = arr[0].length;
        ft = new int[n + 1][m + 1];
        build(arr);
    }

    /**
     * Get the Least Significant One bit
     */
    private int LSOne(int n) {
        return (n & (-n));
    }
    
    /**
     * Build the 2D Fenwick Tree
     */
    private void build(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                update(i + 1, j + 1, arr[i][j]);
            }
        }
    }

    /**
     * Update a point in the 2D Fenwick Tree
     */
    public void update(int row, int col, int value) {
        for (int i = row; i < ft.length; i += LSOne(i)) {
            for (int j = col; j < ft[0].length; j += LSOne(j)) {
                ft[i][j] += value;
            }
        }
    }

    /**
     * Query sum from (0,0) to (row, col)
     */
    private int querySum(int row, int col) {
        int sum = 0;
        for (int i = row; i > 0; i -= LSOne(i)) {
            for (int j = col; j > 0; j -= LSOne(j)) {
                sum += ft[i][j];
            }
        }
        return sum;
    }

    /**
     * Range sum query from (x1, y1) to (x2, y2)
     * Uses inclusion-exclusion principle
     */
    public int rangeSum(int x1, int y1, int x2, int y2) {
        return querySum(x2, y2) - querySum(x1 - 1, y2) - querySum(x2, y1 - 1) + querySum(x1 - 1, y1 - 1);
    }

    public static void main(String[] args) {
        // Test case 1: arr = [[1,2],[3,4]]
        int[][] arr1 = {{1, 2}, {3, 4}};
        FenwickTree2D ft1 = new FenwickTree2D(arr1);
        int result1 = ft1.rangeSum(0, 0, 1, 1);
        int expected1 = 10;
        String status1 = result1 == expected1 ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: " + expected1 + ", Got: " + result1 + " [" + status1 + "]");
    }
}
