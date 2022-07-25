package _34;

public class SearchRange {
    int[] nums;
    int target;
    int[] answer;

    public int[] searchRange(int[] nums, int target) {
        this.answer = new int[]{nums.length, -1};
        this.nums = nums;
        this.target = target;

        searchWithinRange(0, nums.length - 1);

        if (this.answer[0] == nums.length) {
            answer[0] = -1;
        }

        return answer;
    }

    private void searchWithinRange(int startIdx, int endIdx) {
        if (startIdx < 0 || endIdx >= nums.length || startIdx > endIdx) {
            return;
        }

        int mid = (startIdx + endIdx) / 2;
        if (nums[mid] == target) {
//          Evaluate max
            int nextIdx = Math.min(mid + 1, endIdx);
            if (mid == endIdx || nums[nextIdx] != target) {
                answer[1] = Math.max(mid, answer[1]);
            } else {
                searchWithinRange(mid + 1, endIdx);
            }

//          Evaluate min
            int prevIdx = Math.max(startIdx, mid - 1);
            if (mid == startIdx || nums[prevIdx] != target) {
                answer[0] = Math.min(mid, answer[0]);
            } else {
                searchWithinRange(startIdx, mid - 1);
            }
        } else if (nums[mid] > target) {
            searchWithinRange(startIdx, mid - 1);
        } else {
            searchWithinRange(mid + 1, endIdx);
        }
    }

    public void driver() {
        int[] nums = new int[]{8, 8, 8, 8, 8, 8};
        int target = 8;
        int[] answer = this.searchRange(nums, target);
        System.out.println(answer[0] + " " + answer[1]);
    }

}
