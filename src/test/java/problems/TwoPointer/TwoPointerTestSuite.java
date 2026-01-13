package problems.TwoPointer;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
    ValidPalindromeTest.class,
    TwoSumIITest.class,
    ThreeSumTest.class,
    ContainerWithMostWaterTest.class,
    TrappingRainWaterTest.class
})
public class TwoPointerTestSuite {
}