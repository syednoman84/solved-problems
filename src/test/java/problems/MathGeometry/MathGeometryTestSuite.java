package problems.MathGeometry;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
    RotateImageTest.class,
    SpiralMatrixTest.class,
    SetMatrixZeroesTest.class,
    HappyNumberTest.class,
    PlusOneTest.class,
    PowXNTest.class,
    MultiplyStringsTest.class,
    DetectSquaresTest.class
})
public class MathGeometryTestSuite {
}