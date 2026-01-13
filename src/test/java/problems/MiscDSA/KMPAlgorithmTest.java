package problems.MiscDSA;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class KMPAlgorithmTest {
    private final KMPAlgorithm solution = new KMPAlgorithm();

    @Test
    void testStrStr() {
        assertEquals(2, solution.strStr("hello", "ll"));
        assertEquals(-1, solution.strStr("aaaaa", "bba"));
        assertEquals(0, solution.strStr("", ""));
        assertEquals(0, solution.strStr("abc", ""));
    }
}