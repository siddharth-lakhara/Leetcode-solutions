package _219;

import java.util.HashMap;

public class ContainsNearbyDuplicate {

    private boolean solve(int[] nums, int k) {
        HashMap<Integer, Integer> keyMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (keyMap.containsKey(nums[i])) {
                if ((i - keyMap.get(nums[i]) <= k)) {
                    return true;
                }
            }
            keyMap.put(nums[i], i);

        }
        return false;
    }

    public void driver() {
        int[] nums = new int[]{1,2,3,1};
        int k = 3;
        boolean answer = this.solve(nums, k);
        System.out.println(answer);
    }

}
