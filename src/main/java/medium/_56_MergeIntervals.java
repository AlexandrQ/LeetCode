package main.java.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
    Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

    Example 1:
    Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
    Output: [[1,6],[8,10],[15,18]]
    Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

    Example 2:
    Input: intervals = [[1,4],[4,5]]
    Output: [[1,5]]
    Explanation: Intervals [1,4] and [4,5] are considered overlapping.

    Constraints:
    1 <= intervals.length <= 104
    intervals[i].length == 2
    0 <= starti <= endi <= 104
*/

public class _56_MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(e -> e[0]));
        List<int[]> result = new ArrayList<>();
        int[] interval = intervals[0];
        result.add(interval);
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] <= interval[1] || intervals[i][1] <= interval[1]) {
                interval[1] = Math.max(interval[1], intervals[i][1]);
            } else {
                interval = new int[]{intervals[i][0], intervals[i][1]};
                result.add(interval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}

/*
    Runtime: 7 ms, faster than 78.11% of Java online submissions for Merge Intervals.
    Memory Usage: 47.2 MB, less than 64.37% of Java online submissions for Merge Intervals.
*/
