package _238;

import java.util.Arrays;

public class ProductExceptSelf {

    private int[] solve(int[] nums) {
        int[] answer = new int[nums.length];

//        use the left product
        answer[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            answer[i] = nums[i-1]*answer[i-1];
        }

//        use the right product
        int rProduct = nums[nums.length-1];
        for (int i = nums.length - 2; i >= 0; i--) {
            answer[i] *= rProduct;
            rProduct *= nums[i];
        }

        return answer;
    }

    public void driver() {
        int[] nums = new int[]{-1,1,0,-3,3};
        int[] answer = this.solve(nums);
        System.out.println(Arrays.toString(answer));
    }

}
