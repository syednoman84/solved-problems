/**
 * KMP (Knuth-Morris-Pratt) String Matching Algorithm
 *
 * KMP is an efficient string matching algorithm that finds the first occurrence of a pattern in a text.
 * It uses a failure function to avoid unnecessary comparisons.
 *
 * Approach:
 * - Build a failure function (LPS array) for the pattern
 * - Use the failure function to skip comparisons when a mismatch occurs
 * - Find the pattern in the text efficiently
 *
 * Complexity Analysis:
 * - Time Complexity: O(n + m) where n is text length and m is pattern length
 * - Space Complexity: O(m) for the failure function array
 */
import java.util.Arrays;

public class KMPAlgorithm {
    
    /**
     * Find the first occurrence of needle in haystack
     * Returns the index or -1 if not found
     */
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;
        
        int[] pattern = new int[needle.length()];
        Arrays.fill(pattern, -1);
        buildPattern(needle, pattern);
        return matchIndex(haystack, needle, pattern);
    }
    
    /**
     * Build the failure function (LPS array) for the pattern
     * LPS[i] = length of longest proper prefix which is also suffix for pattern[0..i]
     */
    private void buildPattern(String str, int[] pattern) {
        int j = 0;
        int i = 1;
        while(i < str.length()) {
            if(str.charAt(i) == str.charAt(j)) {
                pattern[i] = j;
                i++;
                j++;
            } else if(j > 0) {
                j = pattern[j-1] + 1;
            } else {
                i++;
            }
        }
    }
    
    /**
     * Match the pattern in the text using the failure function
     */
    private int matchIndex(String str, String substr, int[] pattern) {
        int j = 0, i = 0;
        
        while(i + substr.length() - j <= str.length()) {
            if(str.charAt(i) == substr.charAt(j)) {
                if(j == substr.length()-1)
                    return i-j;
                i++;
                j++;
            } else if(j > 0) {
                j = pattern[j-1] + 1;
            } else {
                i++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        KMPAlgorithm solution = new KMPAlgorithm();
        
        // Test case 1: haystack = "hello", needle = "ll"
        int result1 = solution.strStr("hello", "ll");
        int expected1 = 2;
        String status1 = result1 == expected1 ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: " + expected1 + ", Got: " + result1 + " [" + status1 + "]");
    }
}
