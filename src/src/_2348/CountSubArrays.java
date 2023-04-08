package _2348;

import java.util.ArrayList;

public class CountSubArrays {
    public long zeroFilledSubarray(int[] nums) {
        boolean isCounting = false;
        int runningCount = 0;
        ArrayList<Integer> lengths = new ArrayList<>();

        for (int num : nums) {
            if (num == 0) {
                isCounting = true;
                runningCount++;
            } else if (isCounting) {
                isCounting = false;
                lengths.add(runningCount);
                runningCount = 0;
            }
        }
        
        if (isCounting) {
            lengths.add(runningCount);
        }

        long answer = 0;
        for (Integer length : lengths) {
             answer += ((long) length *(length+1))/2;
        }
        return answer;
    }
    
    public void driver() {
//        int[] nums = new int[] {1,3,0,0,2,0,0,4};
        int[] nums = new int[] {0,0,0,2,0,0};

        long answer = zeroFilledSubarray(nums);
        System.out.println(answer);
    }
}
