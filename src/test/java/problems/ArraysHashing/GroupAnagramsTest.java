package problems.ArraysHashing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class GroupAnagramsTest {
    private final GroupAnagrams solution = new GroupAnagrams();

    @Test
    void testGroupAnagrams() {
        List<List<String>> result1 = solution.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        assertEquals(3, result1.size());
        
        List<List<String>> result2 = solution.groupAnagrams(new String[]{""});
        assertEquals(1, result2.size());
        assertEquals(1, result2.get(0).size());
        assertEquals("", result2.get(0).get(0));
        
        List<List<String>> result3 = solution.groupAnagrams(new String[]{"a"});
        assertEquals(1, result3.size());
        assertEquals(1, result3.get(0).size());
        assertEquals("a", result3.get(0).get(0));
        
        List<List<String>> result4 = solution.groupAnagrams(new String[]{"abc","bca","cab","xyz"});
        assertEquals(2, result4.size());
    }
}