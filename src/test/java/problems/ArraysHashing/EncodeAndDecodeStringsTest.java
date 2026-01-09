package problems.ArraysHashing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class EncodeAndDecodeStringsTest {
    private final EncodeAndDecodeStrings solution = new EncodeAndDecodeStrings();

    @Test
    void testEncodeAndDecode() {
        List<String> input1 = Arrays.asList("lint","code","love","you");
        String encoded1 = solution.encode(input1);
        List<String> decoded1 = solution.decode(encoded1);
        assertEquals(input1, decoded1);

        List<String> input2 = Arrays.asList("we", "say", ":", "yes");
        String encoded2 = solution.encode(input2);
        List<String> decoded2 = solution.decode(encoded2);
        assertEquals(input2, decoded2);

        List<String> input3 = Arrays.asList("");
        String encoded3 = solution.encode(input3);
        List<String> decoded3 = solution.decode(encoded3);
        assertEquals(input3, decoded3);

        List<String> input4 = Arrays.asList("a", "b", "c");
        String encoded4 = solution.encode(input4);
        List<String> decoded4 = solution.decode(encoded4);
        assertEquals(input4, decoded4);

        List<String> input5 = new ArrayList<>();
        String encoded5 = solution.encode(input5);
        List<String> decoded5 = solution.decode(encoded5);
        assertEquals(input5, decoded5);
    }
}