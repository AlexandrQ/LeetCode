package main.java.medium;

/*
    Given an integer n, return the least number of perfect square numbers that sum to n.

    A perfect square is an integer that is the square of an integer; in other words,
    it is the product of some integer with itself.
    For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.

    Example 1:
    Input: n = 12
    Output: 3
    Explanation: 12 = 4 + 4 + 4.

    Example 2:
    Input: n = 13
    Output: 2
    Explanation: 13 = 4 + 9.

    Constraints:
    1 <= n <= 104
*/

public class _279_PerfectSquares {
    private int min = Integer.MAX_VALUE;
    public int numSquares(int n) {
        process(0, n);
        return min;
    }

    private void process(int count, int n) {
        if(count >= min) {
            return;
        }
        double sqrt = Math.sqrt(n);
        if(n < 4) {
            min = Math.min(min, count + n);
        }
        if(isPerfectSqrt(sqrt)) {
            min = Math.min(min, count + 1);
        } else {
            int maxSqrt = getMinInt(sqrt);
            for(int i = maxSqrt; i > maxSqrt / 2; i--) {
                int tail = n - (int)Math.pow(i, 2);
                process(count + 1,tail);
            }
        }
    }

    private boolean isPerfectSqrt(double d) {
        return d % 1 == 0;
    }

    private int getMinInt(double d) {
        return Double.valueOf(d - d%1).intValue();
    }
}

/*
    Runtime: 29 ms, faster than 81.60% of Java online submissions for Perfect Squares.
    Memory Usage: 43.2 MB, less than 19.67% of Java online submissions for Perfect Squares.
*/
