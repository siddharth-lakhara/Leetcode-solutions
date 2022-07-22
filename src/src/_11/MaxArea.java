package _11;

public class MaxArea {

    private int solve(int[] heights) {
        int maxArea = 0;
        int leftIdx = 0;
        int rightIdx = heights.length-1;

        while (leftIdx < rightIdx) {
            int currArea = (rightIdx-leftIdx)*Math.min(heights[leftIdx], heights[rightIdx]);
            if (currArea > maxArea) {
                maxArea = currArea;
            }
            if (heights[leftIdx] < heights[rightIdx]) {
                leftIdx++;
            } else {
                rightIdx--;
            }
        }
        return maxArea;
    }

    public void driver() {
        int[] heights = new int[]{1,1};
        int answer = this.solve(heights);
        System.out.println(answer);
    }

}
