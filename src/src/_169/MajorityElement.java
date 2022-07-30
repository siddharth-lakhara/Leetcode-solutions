package _169;

import java.util.HashMap;

public class MajorityElement {
    private int solve(int[] nums) {
        HashMap<Integer, Integer> freqCounter = new HashMap<>();
        int threshold = nums.length/2;
        for (int num : nums) {
            int newValue = freqCounter.getOrDefault(num, 0)+1;
            if (newValue > threshold) {
                return num;
            } else {
                freqCounter.put(num, newValue);
            }
        }
        return -1;
    }

    public void driver() {
        int[] nums = new int[]{2,2,1,1,1,2,2};
        int answer = solve(nums);
        System.out.println(answer);
    }
}
