package _239;

import java.util.*;

public class SlidingWindowMax {

    private int[] solve(int[] nums, int k) {
        int[] answer = new int[nums.length-k+1];
        int answer_idx = 0;

        Deque<Integer> deque = new ArrayDeque<>();
        int lowerIdx = 0;

        for (int upperIdx = 0; upperIdx<nums.length; upperIdx++) {
            while (deque.size() > 0 && nums[deque.peekLast()] < nums[upperIdx]) {
                deque.pollLast();
            }
            deque.addLast(upperIdx);

            if (upperIdx-lowerIdx+1 == k) {
                answer[answer_idx++] = nums[deque.peekFirst()];
                deque.remove(lowerIdx++);
            }
        }

        return answer;
    }

    public void driver() {
        int[] nums = new int[]{9,10,9,-7,-4,-8,2,-6};
        int slidingWindowSize = 5;

//        expected = [10,10,9,2]

        int[] answer = this.solve(nums, slidingWindowSize);

        System.out.println(Arrays.toString(answer));
    }

}
