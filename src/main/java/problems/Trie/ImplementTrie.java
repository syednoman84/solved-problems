public class ImplementTrie {
    /**
     * [208. Implement Trie (Prefix Tree)](https://leetcode.com/problems/implement-trie-prefix-tree/)
     * Medium
     * 
     * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.
     * 
     * Implement the Trie class:
     * - Trie() Initializes the trie object.
     * - void insert(String word) Inserts the string word into the trie.
     * - boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
     * - boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
     * 
     * Example 1:
     * Input: ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
     * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
     * Output: [null, null, true, false, true, null, true]
     * 
     * Constraints:
     * - 1 <= word.length, prefix.length <= 2000
     * - word and prefix consist only of lowercase English letters.
     * - At most 3 * 10^4 calls in total will be made to insert, search, and startsWith.
     * 
     * Time Complexity:
     * - insert: O(m), where m is the key length.
     * - search: O(m)
     * - startsWith: O(m)
     * 
     * Space Complexity:
     * - insert: O(m)
     * - search: O(1)
     * - startsWith: O(1)
     */
    TrieNode root;
    public ImplementTrie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr  = root;
        for(int i = 0; i < word.length(); i++) {
            int ind = word.charAt(i)-'a';
            
            if(curr.node[ind] != null) {
                curr = curr.node[ind];
            } else {
                curr.node[ind] = new TrieNode();
                curr = curr.node[ind];
            }
        }
        curr.end = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++) {
            int ind = word.charAt(i)-'a';
            if(curr.node[ind] != null)
                curr = curr.node[ind];
            else
                return false;
        }
        return curr.end == true;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i = 0; i < prefix.length(); i++) {
            int ind = prefix.charAt(i)-'a';
            if(curr.node[ind] != null)
                curr = curr.node[ind];
            else
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ImplementTrie trie = new ImplementTrie();
        
        // Test case 1: insert("apple"), search("apple")
        trie.insert("apple");
        boolean result1 = trie.search("apple");
        boolean expected1 = true;
        String status1 = result1 == expected1 ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: " + expected1 + ", Got: " + result1 + " [" + status1 + "]");
    }

    class TrieNode {
        TrieNode[] node = new TrieNode[26];
        boolean end;
    }
}
