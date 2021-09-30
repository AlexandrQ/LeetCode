package main.java.easy;

/*
    Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

    In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

    Example 1:

    Input: rowIndex = 3
    Output: [1,3,3,1]
    Example 2:

    Input: rowIndex = 0
    Output: [1]
    Example 3:

    Input: rowIndex = 1
    Output: [1,1]

    Constraints:

    0 <= rowIndex <= 33

    Follow up: Could you optimize your algorithm to use only O(rowIndex) extra space?
*/

import java.util.ArrayList;
import java.util.List;

public class _119_PascalsTriangle_2 {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>(rowIndex + 1);
        for(int triangleRow = 0; triangleRow < rowIndex + 1; triangleRow++) {
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
        return result.get(result.size() - 1);
    }
}

/*
    Runtime: 2 ms, faster than 18.39% of Java online submissions for Pascal's Triangle II.
    Memory Usage: 38.8 MB, less than 5.69% of Java online submissions for Pascal's Triangle II.
*/


