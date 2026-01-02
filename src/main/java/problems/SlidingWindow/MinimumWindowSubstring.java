/*
 * 76. Minimum Window Substring
 * Hard
 *
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window.
 * If there is no such substring, return the empty string "".
 *
 * Example 1:
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 *
 * Example 2:
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 *
 * Example 3:
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 *
 * Constraints:
 * - m == s.length
 * - n == t.length
 * - 1 <= m, n <= 10^5
 * - s and t consist of uppercase and lowercase English letters.
 */
import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String str, String pattern) {
        int windowStart = 0, minLen = Integer.MAX_VALUE, matched = 0;
        Map<Character, Integer> charFreqMap = new HashMap<>();
        String res = "";
        for (char ch : pattern.toCharArray())
            charFreqMap.put(ch, charFreqMap.getOrDefault(ch, 0) + 1);

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char right = str.charAt(windowEnd);

            if (charFreqMap.containsKey(right)) {
                charFreqMap.put(right, charFreqMap.get(right) - 1);
                if (charFreqMap.get(right) == 0)
                    matched++;
            }

            while (matched == charFreqMap.size()) {
                if (minLen > windowEnd - windowStart + 1) {
                    minLen = windowEnd - windowStart + 1;
                    res = str.substring(windowStart, windowEnd + 1);
                }

                char left = str.charAt(windowStart);
                if (charFreqMap.containsKey(left)) {
                    if (charFreqMap.get(left) == 0)
                        matched--;
                    charFreqMap.put(left, charFreqMap.get(left) + 1);
                }
                windowStart++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MinimumWindowSubstring solution = new MinimumWindowSubstring();
        
        // Test case 1: s = "a", t = "a"
        String result1 = solution.minWindow("a", "a");
        String expected1 = "a";
        String status1 = result1.equals(expected1) ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: " + expected1 + ", Got: " + result1 + " [" + status1 + "]");
    }
}
