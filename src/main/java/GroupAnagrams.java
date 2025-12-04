import java.util.*;

class GroupAnagrams {
    /**
     * Problem:
     *    Group anagrams together from an array of strings.
     *    Anagrams are words or phrases formed by rearranging the letters of another word,
     *    using all original letters exactly once.
     *
     * Example 1:
     *   Input: strs = ["eat","tea","tan","ate","nat","bat"]
     *   Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
     *
     * Explanation:
     *
     *   There is no string in strs that can be rearranged to form "bat".
     *   The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
     *   The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
     * 
     * Solution: Use sorted string as key to group anagrams
     * - Anagrams have identical characters, so sorting produces same key
     * - HashMap groups strings with same sorted key
     * 
     * Time: O(n × m log m) where n=strings count, m=avg string length
     * Space: O(n × m) for storing all strings and keys
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);

            map.computeIfAbsent(sortedWord, k -> new ArrayList<>()).add(word);
        }

        return new ArrayList<>(map.values());
    }
}