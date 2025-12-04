import java.util.*;

class GroupAnagrams {
    /**
     * Problem: Group anagrams together from an array of strings
     * Example: ["eat","tea","tan","ate","nat","bat"] -> [["bat"],["nat","tan"],["ate","eat","tea"]]
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