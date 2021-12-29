package main.java.medium;

/*
    Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.

    The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.

    Return the quotient after dividing dividend by divisor.

    Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1, and if the quotient is strictly less than -231, then return -231.

    Example 1:
    Input: dividend = 10, divisor = 3
    Output: 3
    Explanation: 10/3 = 3.33333.. which is truncated to 3.

    Example 2:
    Input: dividend = 7, divisor = -3
    Output: -2
    Explanation: 7/-3 = -2.33333.. which is truncated to -2.

    Example 3:
    Input: dividend = 0, divisor = 1
    Output: 0

    Example 4:
    Input: dividend = 1, divisor = 1
    Output: 1

    Constraints:
    -231 <= dividend, divisor <= 231 - 1
    divisor != 0
*/

public class _29_DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if(dividend == 0) {
            return 0;
        }
        if(divisor == 1) {
            return dividend;
        }
        if(divisor == -1) {
            return -dividend;
        }
        int counter = 0;
        int storage = 0;
        while(methodName(dividend, divisor, storage, counter)) {
            if((divisor < 0 && dividend > 0) || (divisor > 0 && dividend < 0)) {
                if(Integer.MIN_VALUE + Math.abs(storage) > divisor) {
                    return Integer.MAX_VALUE;
                }
                counter--;
            } else if((divisor < 0 && dividend < 0) || (divisor > 0 && dividend > 0)) {
                if(Integer.MAX_VALUE - Math.abs(storage) < divisor) {
                    return Integer.MAX_VALUE;
                }
                counter++;
            }
            storage += divisor;
        }

        return counter;
    }

    //TODO rename
    private boolean methodName(int dividend, int divisor, int storage, int counter) {
        if(storage == Integer.MAX_VALUE ||
                storage == Integer.MIN_VALUE ||
                counter == Integer.MAX_VALUE ||
                counter == Integer.MIN_VALUE) {
            return false;
        }
        if(dividend < 0) {
            if(divisor < 0) {
                return dividend - storage < divisor;
            } else {
                return Math.abs(dividend + storage) >= divisor;
            }
        } else {
            if(divisor < 0) {
                return -(dividend + storage) < divisor;
            } else {
                return Math.abs(dividend - storage) >= divisor;
            }
        }
    }
}
