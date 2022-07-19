package _219;

import java.util.HashSet;

public class ContainsNearbyDuplicate {

    private boolean solve(int[] nums, int k) {
        HashSet<Integer> keySet = new HashSet<>();

        k = Math.min(nums.length-1, k);
        for (int i=0; i<=k; i++) {
            keySet.add(nums[i]);
        }
        if (keySet.size() != k+1) {
            return true;
        }

        for (int i = 1; i < nums.length-k; i++) {
            keySet.remove(nums[i-1]);
            keySet.add(nums[i+k]);
            if (keySet.size() != k+1) {
                return true;
            }
        }
        return false;
    }

    public void driver() {
        int[] nums = new int[]{1,2,3,1};
        int k = 1;
        boolean answer = this.solve(nums, k);
        System.out.println(answer);
    }

}
