package _217;

import java.util.HashSet;

public class ContainsDuplicate {

    private boolean solve(int[] nums) {
        HashSet<Integer> keyMap = new HashSet<>();
        for (int n: nums) {
            if (keyMap.contains(n)) {
                return true;
            } else {
                keyMap.add(n);
            }
        }
        return false;
    }

    public void driver() {
        int[] nums = new int[]{1,1,1,3,3,4,3,2,4,2};
        boolean answer = this.solve(nums);
        System.out.println(answer);
    }

}
