package _57;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertIntervals {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> answer = new ArrayList<>();

        int idx = 0;
        for (; idx < intervals.length; idx++) {
            if (newInterval[0] <= intervals[idx][1]) {
                break;
            }
            answer.add(intervals[idx]);
        }

//        new interval is not overlapping
        answer.add(newInterval);
        int finalIdx = this.startMerge(answer, intervals, idx);
        if (finalIdx < intervals.length) {
            List<int[]> remainingList = Arrays.asList(intervals).subList(finalIdx, intervals.length);
            answer.addAll(remainingList);
        }

        return answer.toArray(new int[0][]);
    }

    private int startMerge(ArrayList<int[]> answer, int[][] intervals, int idx) {
        if (idx >= intervals.length) {
            return idx;
        }
        int[] lastInterval = answer.get(answer.size()-1);
        int[] nextInterval = intervals[idx];
        if (lastInterval[1] >= nextInterval[0]) {
            lastInterval[0] = Math.min(lastInterval[0], nextInterval[0]);
            lastInterval[1] = Math.max(lastInterval[1], nextInterval[1]);
            return startMerge(answer, intervals, idx+1);
        }
        return idx;
    }

    public void driver() {
        int[][] intervals = new int[][]{{1,5}};
        int[] newInterval = new int[]{5,7};
        int[][] answer = this.insert(intervals, newInterval);
        System.out.println(answer);
    }

}
