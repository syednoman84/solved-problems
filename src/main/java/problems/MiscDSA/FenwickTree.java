package problems.MiscDSA;

/**
 * Fenwick Tree (Binary Indexed Tree) Data Structure
 *
 * A Fenwick Tree is a data structure that can efficiently update elements and calculate prefix sums in O(log n) time.
 * It uses the Least Significant One (LSOne) bit trick for efficient navigation.
 *
 * Approach:
 * - Use LSOne(n) = n & (-n) to find the lowest set bit
 * - Build the tree by accumulating values
 * - Query using prefix sums
 * - Update by propagating changes up the tree
 *
 * Complexity Analysis:
 * - Build: O(n log n)
 * - Query: O(log n)
 * - Update: O(log n)
 * - Space Complexity: O(n)
 */
public class FenwickTree {
    int[] ft, nums;

    /**
     * Get the Least Significant One bit
     */
    private int LSOne(int n) {
        return (n & (-n));
    }

    public FenwickTree(int n, int[] nums) {
        ft = new int[n + 1];
        this.nums = nums;
        build(nums);
    }

    /**
     * Build the Fenwick Tree
     */
    private void build(int[] nums) {
        for (int j = 0; j < nums.length; j++) {
            for (int i = j + 1; i <= nums.length; i += LSOne(i)) {
                ft[i] += nums[j];
            }
        }
    }

    /**
     * Range Sum Query from 0 to i
     */
    private int rsq(int i) {
        int sum = 0;
        for (; i > 0; i -= LSOne(i))
            sum += ft[i];
        return sum;
    }

    /**
     * Sum of elements from index i to j
     */
    public int sumRange(int i, int j) {
        return rsq(j + 1) - rsq(i);
    }

    /**
     * Update element at index ind to val
     */
    public void update(int ind, int val) {
        int tmp = nums[ind];
        nums[ind] = val;
        ind++;
        for (; ind < ft.length; ind += LSOne(ind))
            ft[ind] += (val - tmp);
    }

    public static void main(String[] args) {
        // Test case 1: nums = [1, 2, 3, 4, 5]
        int[] nums1 = {1, 2, 3, 4, 5};
        FenwickTree ft1 = new FenwickTree(5, nums1);
        int result1 = ft1.sumRange(0, 2);
        int expected1 = 6;
        String status1 = result1 == expected1 ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: " + expected1 + ", Got: " + result1 + " [" + status1 + "]");
    }
}
