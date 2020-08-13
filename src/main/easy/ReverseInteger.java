package main.easy;

public class ReverseInteger {

    /*
        Given a 32-bit signed integer, reverse digits of an integer.

        Example 1:
            Input: 123
            Output: 321
        Example 2:
            Input: -123
            Output: -321
        Example 3:
            Input: 120
            Output: 21

        Note:
        Assume we are dealing with an environment which could only store integers within the 32-bit
        signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your
        function returns 0 when the reversed integer overflows.
    */

    final int INT_RIGHT_LIMIT = 2147483647;
    final int INT_LEFT_LIMIT = -2147483648;
    final int SIZE_LIMIT = 10;

    public int reverse(int x) {

        int counter = 0;
        int result = 0;

        while(x != 0) {
            if(counter == SIZE_LIMIT - 1) {
                if(x > 0) {
                    if((INT_RIGHT_LIMIT/10) - result < 0 || x % 10 > INT_RIGHT_LIMIT % 10) {
                        return 0;
                    }
                } else {
                    if((INT_LEFT_LIMIT/10) - result > 0 || x % 10 < INT_LEFT_LIMIT % 10) {
                        return 0;
                    }
                }

            }

            result = (result * 10) + x % 10;
            x = x / 10;
            counter++;
        }
        return result;
    }


    /*
       Runtime: 1 ms, faster than 100.00% of Java online submissions for Reverse Integer.
       Memory Usage: 36.5 MB, less than 90.32% of Java online submissions for Reverse Integer.
    */
}
