package _153;

public class MinInRotatedSortedArr {
    int[] nums;
    int answer;

    public int findMin(int[] nums) {
        this.nums = nums;
        this.answer = Integer.MAX_VALUE;
        searchWithinRange(0, nums.length - 1);
        return answer;
    }

    private void searchWithinRange(int startIdx, int endIdx) {
        if (startIdx > endIdx) {
            return;
        }

        int mid = (startIdx + endIdx) / 2;
        answer = Math.min(answer, nums[mid]);

        boolean isFirstHalfIncreasing = nums[mid] > nums[startIdx];
        boolean isSecondHalfIncreasing = nums[endIdx] > nums[mid];

        if (isFirstHalfIncreasing && isSecondHalfIncreasing) {
            answer = Math.min(answer, nums[startIdx]);
        } else if (!isFirstHalfIncreasing && !isSecondHalfIncreasing) {
            answer = Math.min(answer, nums[endIdx]);
        } else if (isFirstHalfIncreasing && !isSecondHalfIncreasing) {
            searchWithinRange(mid + 1, endIdx);
        } else {
            searchWithinRange(startIdx, mid - 1);
        }
        return;
    }

    public void driver() {
        int[] nums = new int[]{5};
        int answer = this.findMin(nums);
        System.out.println(answer);
    }

}
