package _1010;

import java.util.HashMap;

public class PairsOfSongs {
    public int numPairsDivisibleBy60(int[] time) {
        int answer = 0;
        HashMap<Integer, Integer> defeceitMap = new HashMap<>();
        for (int t : time) {
            int equivalentTime = t % 60;
            int need = (60 - equivalentTime)%60;
            answer += defeceitMap.getOrDefault(need, 0);

            defeceitMap.put(equivalentTime,
                    defeceitMap.getOrDefault(equivalentTime, 0) + 1);
        }
        return answer;
    }

    public void driver() {
//        int[] time = new int[]{30, 20, 150, 100, 40};
//        int[] time = new int[]{60,60,60};
        int[] time = new int[]{100,20,100,20,100,20};

        int answer = numPairsDivisibleBy60(time);
        System.out.println(answer);
    }
}
