package _983;

import java.util.HashMap;

public class TicketCost {
    private int[] days;
    private int[] costs;
    private HashMap<Integer, Integer> cache;
    private static final int[] passDayCount = new int[]{1,7,30};
    
    public int mincostTickets(int[] days, int[] costs) {
        this.cache = new HashMap<>();
        this.days = days;
        this.costs = costs;

        for (int idx = days.length-1; idx >= 0; idx--) {
            findMinCost(idx);
        }
        
        return cache.get(0);
    }

    private int findMinCost(int idx) {
        if (idx>=days.length) {
            return 0;
        }
        
        if (cache.containsKey(idx)) {
            return cache.get(idx);
        }

        for (int costIdx = 0; costIdx < costs.length; costIdx++) {
            int nextIdx = idx+1;

            for (; nextIdx < days.length; nextIdx++) {
                if (days[nextIdx] > days[idx]+passDayCount[costIdx]-1) {
                    break;
                }
            }
            
            int minCost = Math.min(cache.getOrDefault(idx, Integer.MAX_VALUE), costs[costIdx]+findMinCost(nextIdx));
            cache.put(idx, minCost);
        }
        
        return cache.get(idx);
    }
    
    public void driver() {
        int[] days = new int[]{1,4,6,7,8,20};
        int[] costs = new int[]{2,7,15};
        
        int answer = mincostTickets(days, costs);
        
        System.out.println(answer);
    }

}
