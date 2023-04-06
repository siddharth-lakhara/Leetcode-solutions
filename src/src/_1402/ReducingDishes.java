package _1402;

import java.util.Arrays;

public class ReducingDishes {

    public int maxSatisfaction(int[] satisfaction) {
        int maxResult = 0;
        Arrays.sort(satisfaction);

        int runningSum = 0;
        int runningResult = 0;
        for (int idx = satisfaction.length - 1; idx >= 0; idx--) {
            int currentElem = satisfaction[idx];
            
            runningResult += currentElem + runningSum;
            runningSum += currentElem;
            
            maxResult = Math.max(maxResult, runningResult);
        }
        
        return maxResult;
    }

    public void driver() {
        int[] satisfaction = new int[]{4,3,2};
        int answer = maxSatisfaction(satisfaction);
        System.out.println(answer);
    }
}
