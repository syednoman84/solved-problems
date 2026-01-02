package problems.DynamicProgrammingI;

/**
 * [5. Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/)
 * Medium
 *
 * Given a string s, return the longest palindromic substring in s.
 *
 * Example 1:
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 *
 * Example 2:
 * Input: s = "cbbd"
 * Output: "bb"
 *
 * Constraints:
 * - 1 <= s.length <= 1000
 * - s consist of only digits and English letters.
 *
 * Approach:
 * - for each index, try to find odd length & even length palindromes
 * - odd: start the inner loop from the same index
 * - even: start the inner loop one pointer on i and other at i+1
 * - expand towards the left and right of i while the chars are same
 * - keep checking the len, and store the start and end
 * - substring(start,end+1), end+1 because the substring method takes end index one more than the original end index
 *
 * Complexity Analysis:
 * - Time Complexity: O(N*N)
 * - Space Complexity: O(1)
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int resLen = 0, start = 0, end = 0;
        
        if(s == null || s.length() == 0)
            return "";
                
        for(int i = 0; i < s.length(); i++) {
            
            // odd length palindromes
            int left = i, right = i;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if(right-left+1 > resLen) {
                    start = left;
                    end = right;
                    resLen = right-left+1;
                }
                left--;
                right++;
            }
            
            // even length palindromes
            left = i;
            right = i+1;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if(right-left+1 > resLen) {
                    start = left;
                    end = right;
                    resLen = right-left+1;
                }
                left--;
                right++;
            }

        }
        
        return s.substring(start, end+1);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
        
        // Test case 1
        String s = "babad";
        String result = solution.longestPalindrome(s);
        boolean expected = result.equals("bab") || result.equals("aba");
        String status = expected ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: bab or aba, Got: " + result + " [" + status + "]");
    }
}
