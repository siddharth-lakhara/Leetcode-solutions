package _55;

public class JumpGame {

    boolean[] cache;
    public boolean canJump(int[] nums) {
        cache = new boolean[nums.length];
        cache[nums.length-1] = true;
        for (int idx = nums.length - 2; idx >= 0; idx--) {
            evaluateJumps(nums, idx);
        }
        return cache[0];
    }
    
    private void evaluateJumps(int[] nums, int idx) {
        int jumps = nums[idx];

        for (int jumpIdx = 1; jumpIdx <= jumps; jumpIdx++) {
            if (cache[idx+jumpIdx]) {
                cache[idx] = true;
                return;
            }
        }
        
        cache[idx] = false;
    }
    
    public void driver() {
        int[] nums = new int[]{3,2,1,0,4};
        boolean answer = canJump(nums);
        System.out.println(answer);
    }

}
