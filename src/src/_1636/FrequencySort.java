package _1636;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class FrequencySort {

    private int[] solve(int[] nums) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for (int n: nums) {
            freqMap.put(n, freqMap.getOrDefault(n, 0)+1);
        }

        ArrayList<Integer> sortedKeys = new ArrayList<Integer>(freqMap.keySet());
        Collections.sort(sortedKeys, (a, b) -> {
            if (freqMap.get(a) == freqMap.get(b)) {
                return b-a;
            } else {
                return freqMap.get(a) - freqMap.get(b);
            }
        });

        int[] answer = new int[nums.length];
        int numsIdx = 0;
        for (int keyIdx=0; keyIdx<sortedKeys.size(); keyIdx++) {
            int currNum = sortedKeys.get(keyIdx);
            int totalRepeatCount = freqMap.get(currNum);
            for (int repeatCount=0; repeatCount<totalRepeatCount; repeatCount++) {
                answer[numsIdx++] = currNum;
            }
        }

        return answer;
    }

    public void driver() {
        int[] nums = new int[]{2,3,1,3,2};
        int[] answer = this.solve(nums);
        System.out.println(Arrays.toString(answer));
    }

}
