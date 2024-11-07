package _2275;

import java.util.HashMap;

public class LargestCombination {
    public int largestCombination(int[] candidates) {
        HashMap<Integer, Integer> counter = new HashMap<>();
        int max = 0;
        for (int candidate: candidates) {
            int bitIdx = 0;
            while (candidate > 0) {
                int bit = candidate & 1;
                if (bit == 1) {
                    int newValue = counter.getOrDefault(bitIdx, 0)+1;
                    counter.put(
                            bitIdx, newValue
                    );

                    if (newValue > max) {
                        max = newValue;
                    }
                }

                bitIdx++;
                candidate = candidate >> 1;
            }
        }
        return max;
    }
    
    public void driver() {
        int[] candidates = new int[]{16,17,71,62,12,24,14};
        int answer = largestCombination(candidates);
        System.out.println(answer);
    }
}
