package _45;

import java.util.Arrays;

public class JumpGame2 {

    int[] cache;
    public int jump(int[] nums) {
        cache = new int[nums.length];
        Arrays.fill(cache, -1);
        cache[nums.length-1] = 0;
        for (int idx = nums.length - 2; idx >= 0; idx--) {
            evaluateJumps(nums, idx);
        }
        return cache[0];
    }
    
    private void evaluateJumps(int[] nums, int idx) {
        boolean reachable = false;
        int jumps = nums[idx];
        int minSoFar = Integer.MAX_VALUE; 
        
        for (int jumpIdx = 1; jumpIdx <= jumps && idx+jumpIdx<nums.length; jumpIdx++) {
            if (cache[idx+jumpIdx] != -1) {
                reachable = true;
                minSoFar = Math.min(
                        minSoFar,
                        1 + cache[idx+jumpIdx]
                );   
            }
        }
        
        if (reachable) {
            cache[idx] = minSoFar;    
        } else {
            cache[idx] = -1;
        }
        
    }
    
    public void driver() {
        int[] nums = new int[]{2,3,1,1,4};
        int answer = jump(nums);
        System.out.println(answer);
    }

}
