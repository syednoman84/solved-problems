package problems.Backtracking;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class LetterCombinationsOfAPhoneTest {
    private final LetterCombinationsOfAPhone solution = new LetterCombinationsOfAPhone();

    @Test
    void testLetterCombinations() {
        assertEquals(9, solution.letterCombinations("23").size());
        assertEquals(0, solution.letterCombinations("").size());
        assertEquals(3, solution.letterCombinations("2").size());
        assertEquals(9, solution.letterCombinations("34").size());
        assertEquals(4, solution.letterCombinations("7").size());
    }
}