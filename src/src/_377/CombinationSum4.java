package _377;

import java.util.HashMap;

public class CombinationSum4 {

    public int combinationSum4(int[] nums, int target) {
        int[] combSums = new int[target+1];
        combSums[0] = 1; // DP base case
        int currTarget = 1;
        while (currTarget <= target) {
            for (int n : nums) {
                int balance = currTarget - n;
                if (balance < 0) {
                    continue;
                }
                combSums[currTarget] += combSums[balance];
            }
            currTarget++;
        }

        return combSums[combSums.length-1];
    }

    public void driver() {
        int[] nums = new int[]{9};
        int target = 4;
        int answer = this.combinationSum4(nums, target);
        System.out.println(answer);
    }

}
