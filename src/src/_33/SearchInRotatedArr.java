package _33;

public class SearchInRotatedArr {

    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length-1);
    }
    
    private int binarySearch(int[] nums, int target, int firstIdx, int lastIdx) {
        if (firstIdx > lastIdx) {
            return -1;
        }
        
        if (nums[firstIdx] == target) {
            return firstIdx;
        }
        if (nums[lastIdx] == target) {
            return lastIdx;
        }
        
        int midIdx = (firstIdx+lastIdx)/2;
        if (nums[midIdx] == target) {
            return midIdx;
        }
   
//        first half
        if (nums[firstIdx] < nums[midIdx]) {
            if (target > nums[firstIdx] && target<nums[midIdx]) {
                return binarySearch(nums, target, firstIdx, midIdx-1);
            }
        } else {
            if (target > nums[firstIdx] || target<nums[midIdx]) {
                return binarySearch(nums, target, firstIdx+1, midIdx-1);
            }
        }
        
//        second half
        if (nums[midIdx] < nums[lastIdx]) {
            if (target > nums[midIdx] && target<nums[lastIdx]) {
                return binarySearch(nums, target, midIdx+1, lastIdx-1);
            }
        } else {
            if (target > nums[midIdx] || target<nums[lastIdx]) {
                return binarySearch(nums, target, midIdx+1, lastIdx-1);
            }
        }
        
        return -1;
    }

    public void driver() {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int target = 2;
        int answer = search(nums, target);
        System.out.println(answer);
    }

}
