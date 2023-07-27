package _167;

import java.util.Arrays;

public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        int[] answer = new int[2];
        int firstIdx = 0;
        int lastIdx = numbers.length-1;
        while (lastIdx > firstIdx) {
            if (numbers[lastIdx] + numbers[firstIdx] > target) {
                lastIdx--;
            } else if (numbers[lastIdx] + numbers[firstIdx] < target) {
                firstIdx++;
            } else {
                answer[0] = firstIdx+1;
                answer[1] = lastIdx+1;
                break;
            }
        }
        
        return answer;
    }

    public void driver() {
//        int[] numbers = new int[]{2,7,11,15};
//        int target = 9;
        int[] numbers = new int[]{-1,0};
        int target = 6;
        
        int[] answer = twoSum(numbers, target);
        System.out.println(Arrays.toString(answer));
    }
}
