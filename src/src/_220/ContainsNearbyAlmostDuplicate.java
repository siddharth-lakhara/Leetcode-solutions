package _220;

import java.util.TreeSet;

public class ContainsNearbyAlmostDuplicate {

    private boolean solve(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (set.size() > k) {
                set.remove((long) nums[i - (k + 1)]);
            }

            Long floor = set.floor((long) nums[i]);
            Long ceil = set.ceiling((long) nums[i]);

            if (floor!=null && Math.abs(floor - nums[i]) <= t) {
                return true;
            } else if (ceil != null && Math.abs(ceil - nums[i]) <= t) {
                return true;
            } else {
                set.add((long) nums[i]);
            }
        }

        return false;
    }

    public void driver() {
        int[] nums = new int[]{1,5,9,1,5,9};
        int k = 2;
        int t = 3;
        boolean answer = this.solve(nums, k, t);
        System.out.println(answer);
    }

}
