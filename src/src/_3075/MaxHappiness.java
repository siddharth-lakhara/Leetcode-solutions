package _3075;

import java.util.Arrays;

public class MaxHappiness {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int turns = 0;
        long answer = 0;
        while (k>0) {
            int curHappiness = happiness[happiness.length-1-turns];
            curHappiness -= turns;
            if (curHappiness <= 0) {
                break;
            }
            answer += curHappiness;

            k--;
            turns++;
        }

        return answer;
    }

    public void driver() {
        int[] happiness = new int[]{2,3,4,5};
        int k = 10;
        long answer = maximumHappinessSum(happiness, k);
        System.out.println(answer);
    }

}
