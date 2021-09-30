package main.java.easy;

/*
    You are climbing a staircase. It takes n steps to reach the top.

    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

    Example 1:

    Input: n = 2
    Output: 2
    Explanation: There are two ways to climb to the top.
    1. 1 step + 1 step
    2. 2 steps
    Example 2:

    Input: n = 3
    Output: 3
    Explanation: There are three ways to climb to the top.
    1. 1 step + 1 step + 1 step
    2. 1 step + 2 steps
    3. 2 steps + 1 step

    Constraints:

    1 <= n <= 45
*/

import java.math.BigInteger;

public class _070_ClimbingStairs {
    public int climbStairs(int n) {
        int countOne = n%2;
        int countTwo = n/2;
        int length = countTwo + countOne;
        int result = 0;
        while (countTwo >= 0) {
            result += calculate(length, countOne, countTwo);
            countOne += 2;
            countTwo--;
            length++;
        }
        return result;
    }


    private int calculate(int arrayLength, int countOne, int countTwo) {
        if(countOne == 0 || countTwo == 0) {
            return 1;
        }
        return (factorial(arrayLength).divide(factorial(countOne).multiply(factorial(countTwo)))).intValue();
    }

    private BigInteger factorial(int num) {
        if(num == 1) {
            return BigInteger.ONE;
        }
        return BigInteger.valueOf(num).multiply(factorial(num - 1));
    }
}

/*
    Runtime: 10 ms, faster than 100.00% of Java online submissions for Climbing Stairs.
    Memory Usage: 40.2 MB, less than 6.21% of Java online submissions for Climbing Stairs.
*/
