package problems.ArraysHashing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ValidAnagramTest {
    private final ValidAnagram solution = new ValidAnagram();

    @Test
    void testIsAnagram() {
        assertTrue(solution.isAnagram("anagram", "nagaram"));
        assertFalse(solution.isAnagram("rat", "car"));
        assertTrue(solution.isAnagram("", ""));
        assertTrue(solution.isAnagram("a", "a"));
        assertFalse(solution.isAnagram("ab", "a"));
        assertFalse(solution.isAnagram("a", "ab"));
        assertTrue(solution.isAnagram("listen", "silent"));
    }
}