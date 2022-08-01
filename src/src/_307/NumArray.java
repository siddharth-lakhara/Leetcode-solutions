package _307;

public class NumArray {
    private int[] nums;
    private int[] segTree;

    public NumArray(int[] nums) {
        this.nums = nums;
        int len = this.getInitialLength(nums.length);
        segTree = new int[len];
        this.constructSegTree(0, nums, 0, nums.length-1);
    }

    private int constructSegTree(int segTreeIdx, int[] nums, int l, int r) {
        if (l == r) { // leafNode
            segTree[segTreeIdx] = nums[l];
        } else {
            int mid = (l+ r)/2;
            segTree[segTreeIdx] = constructSegTree(2*segTreeIdx+1, nums, l, mid) +
                    constructSegTree(2*segTreeIdx+2, nums, mid+1, r);
        }

        return segTree[segTreeIdx];
    }

    private int getInitialLength(int len) {
        int treeHeight = (int) (Math.ceil(Math.log(len)/Math.log(2)) + 1);
        int answer = (int) (Math.pow(2, treeHeight) - 1);
        return answer;
    }

    public void update(int index, int val) {
        int diff = val - nums[index];
        nums[index] = val;
        this.update(0, 0, nums.length - 1, index, diff);
    }

    public void update(int segIdx, int segLeft, int segRight, int pos, int diff) {
        if (segLeft > pos || segRight < pos) {
            return;
        }

        segTree[segIdx] += diff;
        if (segLeft != segRight) {
            int mid = (segLeft + segRight)/2;
            this.update(2*segIdx + 1, segLeft, mid, pos, diff);
            this.update(2*segIdx + 2, mid+1, segRight, pos, diff);
        }
    }

    private int getSum(int segIdx, int segLeft, int segRight, int l, int r) {
//        total overlap
        if (l <= segLeft && r >= segRight ) {
            return segTree[segIdx];
        }

//        no overlap
        if (l > segRight || r < segLeft) {
            return 0;
        }

//        partial overlap
        int mid = (segLeft + segRight)/2;
        return getSum(2*segIdx + 1, segLeft, mid, l, r) + getSum(2*segIdx + 2, mid+1, segRight, l, r);
    }

    public int sumRange(int left, int right) {
        return this.getSum(0, 0, nums.length - 1, left, right);
    }
}
