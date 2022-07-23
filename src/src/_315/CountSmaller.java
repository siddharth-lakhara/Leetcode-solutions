package _315;

import java.util.*;

public class CountSmaller {
    int[] count;
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> answer = new ArrayList<>();
        count = new int[nums.length];
        int[] originalIdx = new int[nums.length];

        for (int i=0; i< nums.length; i++) {
            originalIdx[i] = i;
        }

        makePartition(nums, originalIdx, 0, nums.length-1);

        for (int i=0; i< nums.length; i++) {
            answer.add(count[i]);
        }

        return answer;
    }

    private void makePartition(int[] nums, int[] originalIdx, int startIdx, int endIdx) {
        if (startIdx < endIdx) {
            int mid = (startIdx + endIdx)/2;
            makePartition(nums, originalIdx, startIdx, mid);
            makePartition(nums, originalIdx, mid+1, endIdx);
            merge(nums, originalIdx, startIdx, mid, endIdx);
        }
    }

    private void merge(int[] nums, int[] originalIdx, int startIdx, int mid, int endIdx) {
        int leftSize = mid-startIdx+1;
        int rightSize = endIdx-mid;

        int[] lIdxArr = new int[leftSize];
        int[] rIdxArr = new int[rightSize];

        for (int i = 0; i < leftSize; i++) {
            lIdxArr[i] = originalIdx[startIdx + i];
        }
        for (int i = 0; i < rightSize; i++) {
            rIdxArr[i] = originalIdx[mid + i + 1];
        }

        int leftIdx = 0;
        int rightIdx = 0;
        int finalIdx = startIdx;
        int rightCount = 0;

        while (leftIdx < leftSize && rightIdx < rightSize) {
            if (nums[lIdxArr[leftIdx]] <= nums[rIdxArr[rightIdx]]) {
                originalIdx[finalIdx] = lIdxArr[leftIdx];
                count[lIdxArr[leftIdx]] += rightCount;
                leftIdx++;
            } else {
                originalIdx[finalIdx] = rIdxArr[rightIdx];
                rightIdx++;
                rightCount++;
            }
            finalIdx++;
        }

        while (leftIdx < leftSize) {
            originalIdx[finalIdx] = lIdxArr[leftIdx];
            count[lIdxArr[leftIdx]] += rightCount;
            leftIdx++;
            finalIdx++;
        }
        while (rightIdx < rightSize) {
            originalIdx[finalIdx] = rIdxArr[rightIdx];
            rightIdx++;
            rightCount++;
            finalIdx++;
        }
    }

    public void driver() {
        int[] nums = new int[]{5, -1, -1};
        List<Integer> answer = this.countSmaller(nums);

        System.out.println(answer);
    }

}
