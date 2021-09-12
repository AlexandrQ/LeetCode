package main.easy;

/*
    Given an integer numRows, return the first numRows of Pascal's triangle.

    In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

    Example 1:

    Input: numRows = 5
    Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
    Example 2:

    Input: numRows = 1
    Output: [[1]]

    Constraints:
    1 <= numRows <= 30
*/

import java.util.ArrayList;
import java.util.List;

public class _118_PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        for(int triangleRow = 0; triangleRow < numRows; triangleRow++) {
            List<Integer> prevList = null;
            if(triangleRow > 0) {
                prevList = result.get(triangleRow - 1);
            }
            List<Integer> innerList = new ArrayList<>(triangleRow + 1);
            for(int innerListIndex = 0; innerListIndex < triangleRow + 1; innerListIndex++) {
                if(innerListIndex > 0 && innerListIndex < triangleRow) {
                    innerList.add(prevList.get(innerListIndex - 1) + prevList.get(innerListIndex));
                } else {
                    innerList.add(1);
                }
            }
            result.add(innerList);
        }
        return result;
    }
}

/*
    Runtime: 1 ms, faster than 25.20% of Java online submissions for Pascal's Triangle.
    Memory Usage: 38.4 MB, less than 18.38% of Java online submissions for Pascal's Triangle.
*/


