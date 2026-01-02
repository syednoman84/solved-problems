package problems.DynamicProgrammingI;

/**
 * [647. Palindromic Substrings](https://leetcode.com/problems/palindromic-substrings/)
 * Medium
 *
 * Given a string s, return the number of palindromic substrings in it.
 * A string is a palindrome when it reads the same backward as forward.
 * A substring is a contiguous sequence of characters within the string.
 *
 * Example 1:
 * Input: s = "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 *
 * Example 2:
 * Input: s = "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 *
 * Constraints:
 * - 1 <= s.length <= 1000
 * - s consists of lowercase English letters.
 *
 * Approach:
 * - expand around every element as a center
 * - odd length (i,i)
 * - even length (i,i+1)
 * - increment for each match
 *
 * Complexity Analysis:
 * - Time Complexity: O(N*N)
 * - Space Complexity: O(1)
 */
public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            // Odd Length
            int left = i, right = i;
            while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                result++;
                left -=1;
                right +=1;
            }
            // Even Length
            left = i;
            right = i + 1;
            while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                result++;
                left -=1;
                right +=1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        PalindromicSubstrings solution = new PalindromicSubstrings();
        
        // Test case 1
        String s = "abc";
        int result = solution.countSubstrings(s);
        int expected = 3;
        String status = result == expected ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: " + expected + ", Got: " + result + " [" + status + "]");
    }
}
