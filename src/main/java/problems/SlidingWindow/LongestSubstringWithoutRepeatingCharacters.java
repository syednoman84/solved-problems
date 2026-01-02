package problems.SlidingWindow;

/*
 * 3. Longest Substring Without Repeating Characters
 * Medium
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *
 * Constraints:
 * - 0 <= s.length <= 5 * 10^4
 * - s consists of English letters, digits, symbols and spaces.
 */
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        int maxLen = 0, winStart = 0;
        
        for(int winEnd = 0; winEnd < s.length(); winEnd++) {
            char ch = s.charAt(winEnd);
            if(mp.containsKey(ch)) {
                winStart = Math.max(winStart, mp.get(ch)+1);
            }
            mp.put(ch, winEnd);
            maxLen = Math.max(winEnd - winStart + 1, maxLen);
        }
        return maxLen;        
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
        
        // Test case 1: s = "bbbbb"
        int result1 = solution.lengthOfLongestSubstring("bbbbb");
        int expected1 = 1;
        String status1 = result1 == expected1 ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: " + expected1 + ", Got: " + result1 + " [" + status1 + "]");
    }
}
