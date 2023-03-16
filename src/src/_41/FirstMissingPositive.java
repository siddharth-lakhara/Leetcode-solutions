package _41;

import java.util.SortedSet;
import java.util.TreeSet;

public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        SortedSet<Integer> set = new TreeSet<>();
        for (int i=0; i<=nums.length; i++) {
            set.add(i+1);
        }
        
        for (int n: nums) {
            set.remove(n);
        }
        
        return set.first();
    }

    public void driver() {
        int[] nums = new int[]{7,8,9,11,12};
        int answer = firstMissingPositive(nums);
        System.out.println(answer);
    }

}
