package _1376;

import java.util.Arrays;

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

public class InformEmployee {
    int[] nodeInformTime;
    int[] informTime;
    int[] manager;

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int maxInformTime = 0;
        this.manager = manager;
        this.informTime = informTime;
        this.nodeInformTime = new int[n];
        Arrays.fill(this.nodeInformTime, -1);
        this.nodeInformTime[headID] = informTime[headID];

        for (int idx = 0; idx < n; idx++) {
            if (idx == headID) {
                continue;
            }
            int currInformTime = this.getInformTime(idx);
            maxInformTime = Math.max(maxInformTime, currInformTime);
        }

        return maxInformTime;
    }

    private int getInformTime(int idx) {
        if (this.nodeInformTime[idx] == -1) {
            this.nodeInformTime[idx] = this.getInformTime(manager[idx]) + this.informTime[idx];
        }
        return this.nodeInformTime[idx];
    }

    public void driver() {
        int n = 11;
        int headId = 4;
        int[] manager = new int[]{5,9,6,10,-1,8,9,1,9,3,4};
        int[] informTime = new int[]{0,213,0,253,686,170,975,0,261,309,337};
        int answer = numOfMinutes(n, headId, manager, informTime); // 2560
        System.out.println(answer);
    }
}
