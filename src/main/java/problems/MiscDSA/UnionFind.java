package problems.MiscDSA;

/**
 * Union Find (Disjoint Set Union) Data Structure
 *
 * Union Find is a data structure that keeps track of a set of elements partitioned into a number of disjoint (non-overlapping) subsets.
 * It supports two main operations:
 * - find(x): Determine which subset a particular element is in
 * - union(x, y): Merge two subsets into a single subset
 *
 * This implementation uses path compression in find() and union by rank for optimization.
 *
 * Complexity Analysis:
 * - find(): O(α(n)) where α is the inverse Ackermann function (nearly constant)
 * - union(): O(α(n))
 * - Space Complexity: O(n)
 */
public class UnionFind {
    int[] root;
    int[] rank;
    
    public UnionFind(int size) {
        root = new int[size];
        rank = new int[size];
        
        for(int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 0;
        }
    }
    
    /**
     * Find the root of the set that element x belongs to
     * Uses path compression for optimization
     */
    public int find(int x) {
        if(x == root[x])
            return x;
        return root[x] = find(root[x]);
    }
    
    /**
     * Union two sets containing elements x and y
     * Uses union by rank for optimization
     */
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        
        if(rootX != rootY) {
            if(rank[rootX] > rank[rootY])
                root[rootY] = rootX;
            else if(rank[rootX] < rank[rootY])
                root[rootX] = rootY;
            else {
                root[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
    
    /**
     * Check if two elements are in the same set
     */
    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFind(5);
        
        // Test case 1: union(0, 1) and check if connected
        uf.union(0, 1);
        boolean result1 = uf.isConnected(0, 1);
        boolean expected1 = true;
        String status1 = result1 == expected1 ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: " + expected1 + ", Got: " + result1 + " [" + status1 + "]");
    }
}
