package _1306;

import java.util.HashSet;
import java.util.Set;

public class JumpGame3 {

    boolean[] cache;
    Set<Integer> visitedIdx = new HashSet<>();
    
    public boolean canReach(int[] arr, int start) {
        cache = new boolean[arr.length];
        return startSearch(arr, start);
    }

    private boolean startSearch(int[] arr, int start) {
        visitedIdx.add(start);

        if (arr[start] == 0) {
            cache[start] = true;
            return cache[start];
        }

        boolean isReachable;
        if (start + arr[start] < arr.length) {
            
            if (visitedIdx.contains(start + arr[start])) {
                isReachable = cache[start + arr[start]];
            } else {
                isReachable = canReach(arr, start + arr[start]);
            }
            
            if (isReachable) {
                cache[start] = true;
                return cache[start];
            }
        }

        if (start - arr[start] >= 0) {
            if (visitedIdx.contains(start - arr[start])) {
                isReachable = cache[start - arr[start]];
            } else {
                isReachable = canReach(arr, start - arr[start]);
            }

            if (isReachable) {
                cache[start] = true;
                return cache[start];
            }
        }

        cache[start] = false;
        return cache[start];
    }

    public void driver() {
        int[] nums = new int[]{3,0,2,1,2};
        int start = 1;
        boolean answer = canReach(nums, start);
        System.out.println(answer);
    }

}
