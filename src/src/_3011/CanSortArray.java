package _3011;

public class CanSortArray {
    private static class GroupDetails {
        public int id;
        public int max;
        public int min;

        public GroupDetails(int id, int min, int max) {
            this.id = id;
            this.min = min;
            this.max = max;
        }
    }

    public boolean canSortArray(int[] nums) {
        GroupDetails currGroupDetails = new GroupDetails(Integer.bitCount(nums[0]), nums[0], 0);
        int prevGroupMax = 0;

        for (int num : nums) {
            int group = Integer.bitCount(num);
            if (group == currGroupDetails.id) {
                currGroupDetails.max = Math.max(currGroupDetails.max, num);
                currGroupDetails.min = Math.min(currGroupDetails.min, num);

                if (currGroupDetails.min < prevGroupMax) {
                    return false;
                }
            } else {
                prevGroupMax = currGroupDetails.max;

                currGroupDetails.id = group;
                currGroupDetails.max = num;
                currGroupDetails.min = num;
            }
        }
        return true;
    }

    public void driver() {
        int[] nums = new int[]{3,16,8,4,2};
        boolean answer = canSortArray(nums);
        System.out.println(answer);
    }

}
