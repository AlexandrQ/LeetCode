package main.java.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _56_MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (e1, e2) -> Integer.compare(e1[0], e2[0]));

        List<int[]> list = new ArrayList<>();
        int[] ttt = intervals[0];
        list.add(ttt);
        for(int i = 1; i < intervals.length; i++) {
            if((ttt[0] >= intervals[i][0] && ttt[0] <= intervals[i][1]) ||
                    (ttt[1] >= intervals[i][0] && ttt[1] <= intervals[i][1]) ||
                    (intervals[i][0] >= ttt[0] && intervals[i][0] <= ttt[1]) ||
                    (intervals[i][1] >= ttt[0] && intervals[i][1] <= ttt[1])) {
                ttt[0] = Math.min(ttt[0], intervals[i][0]);
                ttt[1] = Math.max(ttt[1], intervals[i][1]);
            } else {
                ttt = new int[]{intervals[i][0], intervals[i][1]};
                list.add(ttt);
            }
        }

        return list.toArray(new int[list.size()][]);
    }
}
