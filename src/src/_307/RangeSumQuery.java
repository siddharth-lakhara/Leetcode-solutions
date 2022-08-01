package _307;

public class RangeSumQuery {
    public void driver() {
        NumArray numArray = new NumArray(new int[]{1, 2, 5, 6, 7, 9});
        System.out.println(numArray.sumRange(0, 2)); // return 1 + 3 + 5 = 9
        numArray.update(1, 0);   // nums = [1, 2, 5]
        System.out.println(numArray.sumRange(0, 2)); // return 1 + 2 + 5 = 8
    }
}
