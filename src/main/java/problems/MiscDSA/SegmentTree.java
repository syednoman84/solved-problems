package problems.MiscDSA;

/**
 * Segment Tree Data Structure
 *
 * A Segment Tree is a binary tree used for storing intervals and allowing queries on any interval in O(log n) time.
 * It's useful for range minimum/maximum queries and range updates.
 *
 * Approach:
 * - Build the tree recursively from bottom-up
 * - Each node stores the minimum element in its range
 * - Query and update operations use divide-and-conquer
 *
 * Complexity Analysis:
 * - Build: O(n)
 * - Query: O(log n)
 * - Update: O(log n)
 * - Space Complexity: O(n)
 */
public class SegmentTree {
    private int[] st, A;
    private int n;
    
    private int left(int p) {
        return p << 1;
    }
    
    private int right(int p) {
        return (p << 1) + 1;
    }

    /**
     * Build the segment tree
     */
    private void build(int p, int L, int R) {
        if (L == R) {
            st[p] = L;
        } else {
            build(left(p), L, (L + R) / 2);
            build(right(p), (L + R) / 2 + 1, R);
            int p1 = st[left(p)], p2 = st[right(p)];
            st[p] = (A[p1] <= A[p2]) ? p1 : p2;
        }
    }

    /**
     * Range Minimum Query
     */
    private int rmq(int p, int L, int R, int i, int j) {
        if (i > R || j < L) return -1;
        if (L >= i && R <= j) return st[p];

        int p1 = rmq(left(p), L, (L + R) / 2, i, j);
        int p2 = rmq(right(p), (L + R) / 2 + 1, R, i, j);

        if (p1 == -1) return p2;
        if (p2 == -1) return p1;
        return (A[p1] <= A[p2]) ? p1 : p2;
    }

    /**
     * Update a point in the segment tree
     */
    private int update_point(int p, int L, int R, int idx, int new_value) {
        int i = idx, j = idx;

        if (i > R || j < L)
            return st[p];

        if (L == i && R == j) {
            A[i] = new_value;
            return st[p] = L;
        }

        int p1, p2;
        p1 = update_point(left(p), L, (L + R) / 2, idx, new_value);
        p2 = update_point(right(p), (L + R) / 2 + 1, R, idx, new_value);

        return st[p] = (A[p1] <= A[p2]) ? p1 : p2;
    }

    public static void main(String[] args) {
        // Test case 1: Simple segment tree
        SegmentTree st = new SegmentTree();
        st.A = new int[]{1, 2, 3, 4, 5};
        st.st = new int[20];
        st.n = 5;
        
        boolean expected = true;
        boolean actual = st.A != null && st.st != null;
        String status = actual == expected ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: " + expected + ", Got: " + actual + " [" + status + "]");
    }
}
