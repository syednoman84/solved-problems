/*
 * 659 · Encode and Decode Strings
 * 
 * Description:
 * Design an algorithm to encode a list of strings to a string. The encoded string is then sent over 
 * the network and is decoded back to the original list of strings.
 * 
 * Example 1:
 * Input: ["lint","code","love","you"]
 * Output: ["lint","code","love","you"]
 * Explanation: One possible encode method is: "lint:;code:;love:;you"
 * 
 * Example 2:
 * Input: ["we", "say", ":", "yes"]
 * Output: ["we", "say", ":", "yes"]
 * Explanation: One possible encode method is: "we:;say:;:::;yes"
 */

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        char seperator = '`';
        for(String str : strs) {
            sb.append(str.length());
            sb.append(seperator);
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<>();
        int i = 0;
        while(i < str.length()) {
            int j = i;
            while(str.charAt(j) != '`')
                j++;
            int len = Integer.parseInt(str.substring(i, j));
            strs.add(str.substring(j+1, j+1+len));
            i = j + 1 + len;
        }
        return strs; 
    }

    public static void main(String[] args) {
        EncodeAndDecodeStrings solution = new EncodeAndDecodeStrings();
        
        // Test case 1
        List<String> input = new ArrayList<>();
        input.add("lint");
        input.add("code");
        input.add("love");
        input.add("you");
        String encoded = solution.encode(input);
        List<String> decoded = solution.decode(encoded);
        boolean result = input.equals(decoded);
        String status = result ? "PASS" : "FAIL";
        System.out.println("Test 1 - Expected: true, Got: " + result + " [" + status + "]");
    }
}
