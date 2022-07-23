package _315;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountSmallerSoln1 {

    private List<Integer> solve(int[] nums) {
        List<Integer> answer = Arrays.asList(new Integer[nums.length]);
        List<Integer> sortedArr = new ArrayList<>();
        int idx = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            idx = 0;
            for (; idx<sortedArr.size(); idx++) {
                if (sortedArr.get(idx) > nums[i] || sortedArr.get(idx) == nums[i]) {
                    break;
                }
            }
            sortedArr.add(idx, nums[i]);
            answer.set(i, idx);
        }

        return answer;
    }

    public void driver() {
        int[] nums = new int[]{5, -1, -1};
        List<Integer> answer = this.solve(nums);

        System.out.println(answer);
    }

}
