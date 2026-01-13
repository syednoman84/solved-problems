package problems.TwoPointer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ValidPalindromeTest {
    private final ValidPalindrome solution = new ValidPalindrome();

    @Test
    void testIsPalindrome() {
        assertTrue(solution.isPalindrome("A man, a plan, a canal: Panama"));
        assertFalse(solution.isPalindrome("race a car"));
        assertTrue(solution.isPalindrome(" "));
        assertTrue(solution.isPalindrome("a"));
    }
}