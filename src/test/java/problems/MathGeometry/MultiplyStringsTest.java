package problems.MathGeometry;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MultiplyStringsTest {
    private final MultiplyStrings solution = new MultiplyStrings();

    @Test
    void testMultiply() {
        assertEquals("6", solution.multiply("2", "3"));
        assertEquals("56088", solution.multiply("123", "456"));
        assertEquals("0", solution.multiply("0", "0"));
        assertEquals("0", solution.multiply("9133", "0"));
    }
}