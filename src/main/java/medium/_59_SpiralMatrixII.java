package main.java.medium;

/*
    Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

    Example 1:
    Input: n = 3
    Output: [[1,2,3],[8,9,4],[7,6,5]]

    Example 2:
    Input: n = 1
    Output: [[1]]

    Constraints:
    1 <= n <= 20
*/

public class _59_SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int maxCyclesCount = n%2 == 0 ? n/2 : (n + 1)/2;
        int cyclesCount = 0;
        if(n == 1) {
            arr[0][0] = 1;
            return arr;
        }
        int currentNumer = 1;
        //fill first top
        for(int i = 0; i < n; i++) {
            arr[0][i] = currentNumer++;
        }
        //fill first right
        for(int i = 1; i < n; i++) {
            arr[i][n - 1] = currentNumer++;
        }
        //fill first bottom
        for(int i = n - 2; i >= 0; i--) {
            arr[n - 1][i] = currentNumer++;
        }
        //fill first left
        for(int i = n - 2; i >= 1; i--) {
            arr[i][0] = currentNumer++;
        }
        cyclesCount++;
        while(cyclesCount < maxCyclesCount) {
            //fill top
            for(int i = cyclesCount; i < n - cyclesCount; i++) {
                arr[cyclesCount][i] = currentNumer++;
            }
            //fill right
            for(int i = 1 + cyclesCount; i < n - cyclesCount; i++) {
                arr[i][n - 1 - cyclesCount] = currentNumer++;
            }
            //fill bottom
            for(int i = n - 2 - cyclesCount; i >= cyclesCount; i--) {
                arr[n - 1 - cyclesCount][i] = currentNumer++;
            }
            //fill left
            for(int i = n - 2 - cyclesCount; i >= 1 + cyclesCount; i--) {
                arr[i][cyclesCount] = currentNumer++;
            }
            cyclesCount++;
        }
        return arr;
    }
}

/*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Spiral Matrix II.
    Memory Usage: 42.5 MB, less than 6.32% of Java online submissions for Spiral Matrix II.
*/
