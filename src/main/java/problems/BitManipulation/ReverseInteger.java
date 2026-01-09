package problems.BitManipulation;

/*
    You are given a signed 32-bit integer x.

    Return x after reversing each of its digits. After reversing, if x goes outside the signed 32-bit integer range [-2^31, 2^31 - 1], then return 0 instead.

    Solve the problem without using integers that are outside the signed 32-bit integer range.

    Example 1:

    Input: x = 1234

    Output: 4321

    Example 2:

    Input: x = -1234

    Output: -4321

    Example 3:

    Input: x = 1234236467

    Output: 0

    Constraints:

        -2^31 <= x <= 2^31 - 1

 */

public class ReverseInteger {
    public int reverse(int x) {
        final int MIN = -2147483648; // -2^31
        final int MAX = 2147483647;  // 2^31 - 1

        int res = 0;
        while (x != 0) {
            int digit = x % 10;
            x /= 10;

            if (res > MAX / 10 || (res == MAX / 10 && digit > MAX % 10))
                return 0;
            if (res < MIN / 10 || (res == MIN / 10 && digit < MIN % 10))
                return 0;
            res = (res * 10) + digit;
        }

        return res;
    }
}