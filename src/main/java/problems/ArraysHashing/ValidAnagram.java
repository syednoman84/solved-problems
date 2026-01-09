package problems.ArraysHashing;

/*
 * 242. Valid Anagram
 * Easy
 * 
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * 
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, 
 * typically using all the original letters exactly once.
 * 
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * 
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 * 
 * Constraints:
 * - 1 <= s.length, t.length <= 5 * 10^4
 * - s and t consist of lowercase English letters.
 * 
 * Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 * We can use a map, or an array of size equal to the character set size of unicode.
 */

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        
        int[] chars = new int[26];
        
        for(int i = 0; i < s.length(); i++) {
            chars[s.charAt(i)-'a']++;
            chars[t.charAt(i)-'a']--;
        }
        
        for(int n : chars) {
            if(n != 0)
                return false;
        }
        
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram solution = new ValidAnagram();
        
        // Test case 1
        String s1 = "anagram";
        String t1 = "nagaram";
        boolean result1 = solution.isAnagram(s1, t1);
        boolean expected1 = true;
        String status1 = result1 == expected1 ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: " + expected1 + ", Got: " + result1 + " [" + status1 + "]");
        
        // Test case 2
        String s2 = "rat";
        String t2 = "car";
        boolean result2 = solution.isAnagram(s2, t2);
        boolean expected2 = false;
        String status2 = result2 == expected2 ? "PASS" : "FAIL";
        System.out.println("Test 2 - Expected: " + expected2 + ", Got: " + result2 + " [" + status2 + "]");
    }
}
