package _1376;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Test 1
// 6
//        2
//        [1,2,-1,1,2,4]
//        [0,3,1,0,2,0]

//Test 2
//        11
//        4
//                [5,9,6,10,-1,8,9,1,9,3,4]
//[0,213,0,253,686,170,975,0,261,309,337]


// This gives wrong answer
public class InformEmployeeOldSoln {
    int[] levels;
    int[] manager;

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        this.manager = manager;
        this.levels = new int[n];
        Arrays.fill(this.levels, -1);
        this.levels[headID] = 0;
        Map<Integer, Integer> levelTime = new HashMap<>();

        for (int idx = 0; idx < n; idx++) {
            if (idx == headID) {
                continue;
            }
            int currLevel = this.getLevel(idx);
            int currMax = levelTime.getOrDefault(currLevel, 0);
            int directMgr = manager[idx];
            int time = informTime[directMgr];
            levelTime.put(currLevel, Math.max(currMax, time));
        }

        int totalTime = 0;
        for (int levelKey : levelTime.keySet()) {
            totalTime += levelTime.get(levelKey);
        }

        return totalTime;
    }

    private int getLevel(int idx) {
        if (this.levels[idx] == -1) {
            this.levels[idx] = this.getLevel(manager[idx]) + 1;
        }
        return this.levels[idx];
    }

    public void driver() {
        int n = 11;
        int headId = 4;
        int[] manager = new int[]{5, 9, 6, 10, -1, 8, 9, 1, 9, 3, 4};
        int[] informTime = new int[]{0, 213, 0, 253, 686, 170, 975, 0, 261, 309, 337};
        int answer = numOfMinutes(n, headId, manager, informTime); // 2560
        System.out.println(answer);
    }
}
