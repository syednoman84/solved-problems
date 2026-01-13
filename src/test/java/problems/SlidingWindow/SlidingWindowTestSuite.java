package problems.SlidingWindow;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
    BestTimeToBuySellStockTest.class,
    LongestSubstringWithoutRepeatingCharactersTest.class,
    LongestRepeatingCharacterReplacementTest.class,
    PermutationInStringTest.class,
    MinimumWindowSubstringTest.class,
    SlidingWindowMaximumTest.class
})
public class SlidingWindowTestSuite {
}