/**
 * [190. Reverse Bits](https://leetcode.com/problems/reverse-bits/)
 * Easy
 *
 * Reverse bits of a given 32 bits unsigned integer.
 * Note that in some languages, such as Java, there is no unsigned integer type.
 * In this case, both input and output will be given as a signed integer type.
 * They should not affect your implementation, as the integer's internal binary representation is the same,
 * whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement notation.
 *
 * Example 1:
 * Input: n = 00000010100101000001111010011100
 * Output: 964176192 (00111001011110000010100101000000)
 * Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596,
 * so return 964176192 which its binary representation is 00111001011110000010100101000000.
 *
 * Example 2:
 * Input: n = 11111111111111111111111111111101
 * Output: 3221225471 (10111111111111111111111111111111)
 * Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293,
 * so return 3221225471 which its binary representation is 10111111111111111111111111111111.
 *
 * Constraints:
 * - The input must be a binary string of length 32
 *
 * Approach:
 * - For each bit position i from 0 to 31:
 *   - Extract the bit at position i using (n >> i) & 1
 *   - Place it at position (31 - i) in the result using res | (bit << (31 - i))
 *
 * Complexity Analysis:
 * - Time Complexity: O(1) (always 32 iterations)
 * - Space Complexity: O(1)
 */
public class ReverseBits {
    public int reverseBits(int n) {
        int res = 0;
        for(int i = 0; i < 32; i++) {
            int bit = (n >> i) & 1;
            res = res | (bit << (31 - i));
        }
        return res;
    }

    public static void main(String[] args) {
        ReverseBits solution = new ReverseBits();
        
        // Test case 1
        int n = 43261596; // 00000010100101000001111010011100
        int result = solution.reverseBits(n);
        int expected = 964176192; // 00111001011110000010100101000000
        String status = result == expected ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: " + expected + ", Got: " + result + " [" + status + "]");
    }
}
