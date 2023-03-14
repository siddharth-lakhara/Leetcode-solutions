package _1539;

public class KthMissingNum {

    public int findKthPositive(int[] arr, int k) {
        int miss_count = 0;
        int expectedNum = 1;
        for (int currNum : arr) {
            if (currNum != expectedNum) {
                if ((currNum - expectedNum) >= (k - miss_count)) {
                    break;
                } else {
                    miss_count += currNum - expectedNum;
                    expectedNum = currNum;
                }
            }
            expectedNum++;
        }
        
        return expectedNum + (k - miss_count - 1);
    }

    public void driver() {
        int[] nums = new int[]{1,2,3,4};
        int k = 2;
        int answer = findKthPositive(nums, k);
        System.out.println(answer);
    }

}
