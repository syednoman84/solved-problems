package problems.MiscDSA;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SegmentTreeTest {

    @Test
    void testSegmentTree() {
        SegmentTree st = new SegmentTree();
        st.A = new int[]{1, 2, 3, 4, 5};
        st.st = new int[20];
        st.n = 5;
        
        assertNotNull(st.A);
        assertNotNull(st.st);
        assertEquals(5, st.n);
        assertEquals(5, st.A.length);
    }
}