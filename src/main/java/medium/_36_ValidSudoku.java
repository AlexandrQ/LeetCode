package main.java.medium;

/*
    Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

    Each row must contain the digits 1-9 without repetition.
    Each column must contain the digits 1-9 without repetition.
    Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.

    Note:
    A Sudoku board (partially filled) could be valid but is not necessarily solvable.
    Only the filled cells need to be validated according to the mentioned rules.

    Example 1:
    Input: board =
    [["5","3",".",".","7",".",".",".","."]
    ,["6",".",".","1","9","5",".",".","."]
    ,[".","9","8",".",".",".",".","6","."]
    ,["8",".",".",".","6",".",".",".","3"]
    ,["4",".",".","8",".","3",".",".","1"]
    ,["7",".",".",".","2",".",".",".","6"]
    ,[".","6",".",".",".",".","2","8","."]
    ,[".",".",".","4","1","9",".",".","5"]
    ,[".",".",".",".","8",".",".","7","9"]]
    Output: true

    Example 2:
    Input: board =
    [["8","3",".",".","7",".",".",".","."]
    ,["6",".",".","1","9","5",".",".","."]
    ,[".","9","8",".",".",".",".","6","."]
    ,["8",".",".",".","6",".",".",".","3"]
    ,["4",".",".","8",".","3",".",".","1"]
    ,["7",".",".",".","2",".",".",".","6"]
    ,[".","6",".",".",".",".","2","8","."]
    ,[".",".",".","4","1","9",".",".","5"]
    ,[".",".",".",".","8",".",".","7","9"]]
    Output: false
    Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.

    Constraints:
    board.length == 9
    board[i].length == 9
    board[i][j] is a digit 1-9 or '.'.
*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _36_ValidSudoku {
    Map<Integer, Set<Integer>> columns = new HashMap<>();
    Map<Integer, Set<Integer>> rows = new HashMap<>();
    Map<Integer, Set<Integer>> blocks = new HashMap<>();

    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if (Character.isDigit(board[i][j])) {
                    int val = Character.getNumericValue(board[i][j]);
                    if(isDuplicate(i, val, columns) ||
                            isDuplicate(j, val, rows) ||
                            isDuplicate(((i/3)*10 + j/3), val, blocks)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean isDuplicate(int key, int val, Map<Integer, Set<Integer>> map) {
        Set<Integer> values = map.get(key);
        if(values == null) {
            Set<Integer> newValues = new HashSet<>();
            newValues.add(val);
            map.put(key, newValues);
            return false;
        } else if(values.contains(val)) {
            return true;
        } else {
            values.add(val);
            return false;
        }
    }
}

/*
    Runtime: 2 ms, faster than 83.73% of Java online submissions for Valid Sudoku.
    Memory Usage: 38.7 MB, less than 91.95% of Java online submissions for Valid Sudoku.
*/
