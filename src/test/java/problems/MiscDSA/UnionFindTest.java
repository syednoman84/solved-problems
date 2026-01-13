package problems.MiscDSA;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UnionFindTest {

    @Test
    void testUnionFind() {
        UnionFind uf = new UnionFind(5);
        assertFalse(uf.isConnected(0, 1));
        uf.union(0, 1);
        assertTrue(uf.isConnected(0, 1));
        uf.union(2, 3);
        assertFalse(uf.isConnected(0, 2));
        uf.union(1, 2);
        assertTrue(uf.isConnected(0, 3));
    }
}