package _198;

import java.util.HashMap;

public class HouseRobber {
    public int rob(int[] nums) {
        int[] cache = new int[nums.length];
        cache[0] = nums[0];
        if (nums.length>1) {
            cache[1] = Math.max(nums[0], nums[1]);
        }
        for (int idx=2; idx<nums.length; idx++) {
            cache[idx] = Math.max(
                    cache[idx-1],
                    nums[idx] + cache[idx-2]
            );
        }

        return cache[cache.length-1];
    }

    public void driver() {
        int[] nums = new int[]{1,2,3,1};
        int answer = rob(nums);
        System.out.println(answer);
    }
}
