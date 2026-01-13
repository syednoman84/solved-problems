package problems.Trie;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DesignAddandSearchWordDataStructureTest {

    @Test
    void testWordDictionary() {
        DesignAddandSearchWordDataStructure dict = new DesignAddandSearchWordDataStructure();
        dict.addWord("bad");
        dict.addWord("dad");
        dict.addWord("mad");
        assertFalse(dict.search("pad"));
        assertTrue(dict.search("bad"));
        assertTrue(dict.search(".ad"));
        assertTrue(dict.search("b.."));
    }
}