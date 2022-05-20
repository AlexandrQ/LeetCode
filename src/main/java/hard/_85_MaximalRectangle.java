package main.java.hard;

/*
    Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

    Example 1:
    Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
    Output: 6
    Explanation: The maximal rectangle is shown in the above picture.

    Example 2:
    Input: matrix = [["0"]]
    Output: 0

    Example 3:
    Input: matrix = [["1"]]
    Output: 1

    Constraints:
    rows == matrix.length
    cols == matrix[i].length
    1 <= row, cols <= 200
    matrix[i][j] is '0' or '1'.
*/

public class _85_MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int maxArea = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == '1') {
                    int area = getMaxVerticalArea(i, j, matrix);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    private int getMaxVerticalArea(int row, int col, char[][] matrix) {
        int maxArea = 0;
        int height = 0;
        int width = 0;
        int maxWidthIndex = matrix[0].length;
        for(int i = row; i < matrix.length; i++) {
            if(matrix[i][col] == '1') {
                height++;
                width = 0;
                for(int j = col; j < maxWidthIndex; j++) {
                    if(matrix[i][j] == '1') {
                        width++;
                        int area = height * width;
                        maxArea = Math.max(maxArea, area);
                    } else {
                        maxWidthIndex = j;
                        break;
                    }
                }
            } else {
                break;
            }
        }
        return maxArea;
    }
}

/*
    Runtime: 517 ms, faster than 5.03% of Java online submissions for Maximal Rectangle.
    Memory Usage: 47.1 MB, less than 78.37% of Java online submissions for Maximal Rectangle.
*/
