package _53;

public class MaxSumSubArray {

    private int solve(int[] nums) {
        int maxSoFar = nums[0];
        int globalMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxSoFar = Math.max(nums[i], maxSoFar + nums[i]);
            if (maxSoFar > globalMax) {
                globalMax = maxSoFar;
            }
        }

        return globalMax;
    }

    public void driver() {
        int[] nums = new int[]{-99,-99,-99,4,-1,100,1,-99,4,4};
        int answer = this.solve(nums);
        System.out.println(answer);
    }

}
