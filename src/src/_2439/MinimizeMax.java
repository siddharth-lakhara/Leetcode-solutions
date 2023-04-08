package _2439;

public class MinimizeMax {
    public int minimizeArrayValue(int[] nums) {
        long max = nums[0];
        long sum = nums[0];

        for (int idx = 1; idx < nums.length; idx++) {
            sum += nums[idx];
            double len = idx+1;
            long newMax = (long) Math.ceil(sum/len);
            max = Math.max(max, newMax);
        }
        
        return (int) max;
    }
    
    public void driver() {
        int[] nums = new int[]{3,7,1,6}; 
        int answer = minimizeArrayValue(nums);

        System.out.println(answer);
    }

}
