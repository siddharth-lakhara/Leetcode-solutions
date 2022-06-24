package _4;

import java.lang.System;

public class MedianOfMergedArray {
    private double solve(int[] nums1, int[] nums2) {
        int[] results = new int[nums1.length + nums2.length];

        int resultsIdx = 0;
        int nums1Idx = 0;
        int nums2Idx = 0;

        while (nums1Idx < nums1.length && nums2Idx < nums2.length) {
            if (nums1[nums1Idx] <= nums2[nums2Idx]) {
                results[resultsIdx] = nums1[nums1Idx];
                nums1Idx++;
            } else {
                results[resultsIdx] = nums2[nums2Idx];
                nums2Idx++;
            }
            resultsIdx++;
        }

        boolean isNums1Completed = nums1Idx == nums1.length;
        boolean isNum2Completed = nums2Idx == nums2.length;
        if (isNums1Completed ^ isNum2Completed) {
            if (isNums1Completed) {
                System.arraycopy(nums2, nums2Idx, results, resultsIdx, nums2.length-nums2Idx);
            } else {
                System.arraycopy(nums1, nums1Idx, results, resultsIdx, nums1.length-nums1Idx);
            }
        }

        double median = 0.0;
        if (results.length %2 == 0) {
            int upperIdx = results.length/ 2;
            int lowerIdx = upperIdx - 1;
            median = (double)(results[lowerIdx] + results[upperIdx])/2;
        } else {
            int idx = results.length/2;
            median = (double)(results[idx]);
        }
        return median;
    }

    public void driver() {
        int nums1[] = new int[] {1, 2};
        int nums2[] = new int[] {3, 4};

        double answer = solve(nums1, nums2);
        System.out.println(answer);
    }
}
