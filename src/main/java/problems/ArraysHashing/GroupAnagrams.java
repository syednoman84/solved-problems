package problems.ArraysHashing;

/*
 * 49. Group Anagrams
 * Medium
 * 
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * 
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, 
 * typically using all the original letters exactly once.
 * 
 * Example 1:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 
 * Example 2:
 * Input: strs = [""]
 * Output: [[""]]
 * 
 * Example 3:
 * Input: strs = ["a"]
 * Output: [["a"]]
 * 
 * Constraints:
 * - 1 <= strs.length <= 10^4
 * - 0 <= strs[i].length <= 100
 * - strs[i] consists of lowercase English letters.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> mp = new HashMap<>();
        for (String str : strs) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String r = new String(c);
            if (!mp.containsKey(r))
                mp.put(r, new ArrayList<String>());
            mp.get(r).add(str);
        }
        for (String key : mp.keySet()) {
            res.add(mp.get(key));
        }

        return res;
    }

    public static void main(String[] args) {
        GroupAnagrams solution = new GroupAnagrams();
        
        // Test case 1
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> result = solution.groupAnagrams(strs);
        int expected = 3;
        String status = result.size() == expected ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected groups: " + expected + ", Got: " + result.size() + " [" + status + "]");
    }
}
