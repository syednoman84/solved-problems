package problems.Trie;

public class DesignAddandSearchWordDataStructure {
    /**
     * [211. Design Add and Search Words Data Structure]()
     * Medium
     * 
     * Design a data structure that supports adding new words and finding if a string matches any previously added string.
     * 
     * Implement the WordDictionary class:
     * - WordDictionary() Initializes the object.
     * - void addWord(word) Adds word to the data structure, it can be matched later.
     * - bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
     * 
     * Example:
     * Input: ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
     * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
     * Output: [null,null,null,null,false,true,true,true]
     * 
     * Constraints:
     * - 1 <= word.length <= 25
     * - word in addWord consists of lowercase English letters.
     * - word in search consist of '.' or lowercase English letters.
     * - There will be at most 3 dots in word for search queries.
     * - At most 10^4 calls will be made to addWord and search.
     * 
     * Approach:
     * - Use Trie
     */
    TrieNode root;

    public DesignAddandSearchWordDataStructure() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int ind = word.charAt(i) - 'a';

            if (curr.node[ind] != null) {
                curr = curr.node[ind];
            } else {
                curr.node[ind] = new TrieNode();
                curr = curr.node[ind];
            }
        }
        curr.end = true;
    }

    public boolean search(String word) {
        return trivialSearch(word, root);
    }

    private boolean trivialSearch(String word, TrieNode root) {
        TrieNode curr = root;
        if (word.length() == 0)
            return curr.end;
        boolean ans = false;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == '.') {
                for (int j = 0; j < 26; j++) {
                    if (curr.node[j] != null) {
                        ans = trivialSearch(word.substring(i + 1), curr.node[j]);
                        if (ans)
                            return true;
                    }
                }
                return false;
            } else {
                int ind = ch - 'a';
                if (curr.node[ind] != null)
                    curr = curr.node[ind];
                else
                    return false;
            }
        }
        return curr.end;
    }

    public static void main(String[] args) {
        DesignAddandSearchWordDataStructure dict = new DesignAddandSearchWordDataStructure();
        
        // Test case 1: addWord("bad"), search("bad")
        dict.addWord("bad");
        boolean result1 = dict.search("bad");
        boolean expected1 = true;
        String status1 = result1 == expected1 ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: " + expected1 + ", Got: " + result1 + " [" + status1 + "]");
    }

    class TrieNode {
        TrieNode[] node = new TrieNode[26];
        boolean end;
    }
}
