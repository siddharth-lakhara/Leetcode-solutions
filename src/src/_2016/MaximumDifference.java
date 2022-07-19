package _2016;

public class MaximumDifference {

    private int solve(int[] nums) {
        int minSoFar = Integer.MAX_VALUE;
        int maxDiffSoFar = -1;
        for (int p : nums) {
            if (p <= minSoFar) {
                minSoFar = p;
            } else {
                maxDiffSoFar = Integer.max(maxDiffSoFar, p-minSoFar);
            }
        }
        return maxDiffSoFar;
    }

    public void driver() {
        int[] nums = new int[]{1,5,2,10};
        int answer = this.solve(nums);
        System.out.println(answer);
    }

}
