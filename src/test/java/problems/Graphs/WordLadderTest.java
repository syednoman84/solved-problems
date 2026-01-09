package problems.Graphs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class WordLadderTest {

    @Test
    void testLadderLength() {
        WordLadder solution = new WordLadder();
        
        // Test case 1: Standard example
        String beginWord1 = "hit";
        String endWord1 = "cog";
        List<String> wordList1 = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        assertEquals(5, solution.ladderLength(beginWord1, endWord1, wordList1));
        
        // Test case 2: No transformation possible
        String beginWord2 = "hit";
        String endWord2 = "cog";
        List<String> wordList2 = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log"));
        assertEquals(0, solution.ladderLength(beginWord2, endWord2, wordList2));
        
        // Test case 3: Direct transformation
        String beginWord3 = "a";
        String endWord3 = "c";
        List<String> wordList3 = new ArrayList<>(Arrays.asList("a","b","c"));
        assertEquals(2, solution.ladderLength(beginWord3, endWord3, wordList3));
        
        // Test case 4: Same begin and end word
        String beginWord4 = "hot";
        String endWord4 = "hot";
        List<String> wordList4 = new ArrayList<>(Arrays.asList("hot"));
        assertEquals(0, solution.ladderLength(beginWord4, endWord4, wordList4));
        
        // Test case 5: Longer transformation chain
        String beginWord5 = "red";
        String endWord5 = "tax";
        List<String> wordList5 = new ArrayList<>(Arrays.asList("ted","tex","red","tax","tad","den","rex","pee"));
        assertEquals(4, solution.ladderLength(beginWord5, endWord5, wordList5));
        
        // Test case 6: Empty word list
        String beginWord6 = "hit";
        String endWord6 = "cog";
        List<String> wordList6 = new ArrayList<>();
        assertEquals(0, solution.ladderLength(beginWord6, endWord6, wordList6));
        
        // Test case 7: Single character words
        String beginWord7 = "a";
        String endWord7 = "b";
        List<String> wordList7 = new ArrayList<>(Arrays.asList("b"));
        assertEquals(2, solution.ladderLength(beginWord7, endWord7, wordList7));
    }
}