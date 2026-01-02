package problems.DynamicProgrammingI;

/**
 * [139. Word Break](https://leetcode.com/problems/word-break/)
 * Medium
 *
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 *
 * Example 1:
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 *
 * Example 2:
 * Input: s = "applepenapple", wordDict = ["apple","pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 *
 * Example 3:
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: false
 *
 * Constraints:
 * - 1 <= s.length <= 300
 * - 1 <= wordDict.length <= 1000
 * - 1 <= wordDict[i].length <= 20
 * - s and wordDict[i] consist of only lowercase English letters.
 * - All the strings of wordDict are unique.
 *
 * Approach:
 * - start from last index
 * - if index + len of word from dict is less than equal to n and substring of s from index to index + len(word) is equal to word
 *   - dp[index] = dp[index + len(word)]
 *   - if dp[index] is true move to next index
 * - dp[0] would have the result
 *
 * Complexity Analysis:
 * - Time Complexity: O(N*len(wordInDict))
 * - Space Complexity: O(N)
 */
import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean dp[] = new boolean[n+1];
        dp[n] = true;
        
        for(int i = n-1; i >= 0; i--) {
            for(String w : wordDict) {
                if(i + w.length() <= n && w.equals(s.substring(i, i+w.length())))
                    dp[i] = dp[i + w.length()];
                
                if(dp[i])
                    break;
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        WordBreak solution = new WordBreak();
        
        // Test case 1
        String s = "leetcode";
        java.util.List<String> wordDict = java.util.Arrays.asList("leet", "code");
        boolean result = solution.wordBreak(s, wordDict);
        boolean expected = true;
        String status = result == expected ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: " + expected + ", Got: " + result + " [" + status + "]");
    }
}
