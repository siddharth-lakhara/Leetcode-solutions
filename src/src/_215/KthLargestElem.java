package _215;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElem {
    private int solve(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int n: nums) {
            pq.add(n);
        }

        while (k > 1) {
            k--;
            pq.remove();
        }
        return pq.remove();
    }

    public void driver() {
        int nums[] = new int[] {3,2,3,1,2,4,5,5,6};
        int k = 4;
        int answer = solve(nums, k);
        System.out.println(answer);
    }
}
