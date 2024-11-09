package _1829;

import java.util.Arrays;

public class MaxiumumXor {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int[] answer = new int[nums.length];
        int inverter = (1<<maximumBit) - 1;

        int xor = 0;
        for (int idx = 0; idx < answer.length; idx++) {
            xor ^= nums[idx];
            answer[answer.length-idx-1] = xor^inverter;
        }
        return answer;
    }
    
    public void driver() {
//        int maximumBit = 2;
//        int[] nums = new int[]{0,1,1,3};

        int maximumBit = 3;
        int[] nums = new int[]{2,3,4,7};

        int[] answer = getMaximumXor(nums, maximumBit);
        System.out.println(Arrays.toString(answer));
    }
}
