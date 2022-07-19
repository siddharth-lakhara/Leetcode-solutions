package _56;

import java.util.*;

public class MergeIntervals {

    private int[][] solve(int[][] intervals) {
        ArrayList<int[]> answer = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int[] interval: intervals) {
            if (interval[0] <= end) {
                end = Math.max(end, interval[1]);
            } else {
                answer.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            }
        }
        answer.add(new int[]{start, end});

        return answer.toArray(new int[0][]);
    }

    public void driver() {
        int[][] intervals = new int[][]{{1,4}, {4,5}};
        int[][] answer = this.solve(intervals);
        System.out.println(answer);
    }

}
