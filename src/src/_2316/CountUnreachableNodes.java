package _2316;

import java.util.Arrays;
import java.util.HashMap;

public class CountUnreachableNodes {
    int[] parent;
    public long countPairs(int n, int[][] edges) {
        parent = new int[n];
        Arrays.setAll(parent, p->p);

        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }
        
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int p : parent) {
            int up = getParent(p);
            int currCount = counter.getOrDefault(up, 0);
            counter.put(up, currCount+1);
        }
        
        long prefixSum = 0;
        long pairs = 0;
        for (Integer value : counter.values()) {
            pairs += prefixSum*value;
            prefixSum += (long) value;
        }
        
        return pairs;
    }

    private void union(int n1, int n2) {
        if (getParent(n1) == getParent(n2)) {
            return;
        }
        int p1 = getParent(n1);
        int p2 = getParent(n2);
        
        parent[p2] = p1;
    }
    
    private int getParent(int idx) {
        if (parent[idx] == idx) {
            return idx;
        }
        
        parent[idx] = getParent(parent[idx]);
        return parent[idx];
    }

    public void driver() {
        int n = 7;
//        int[][] edges = new int[][] {
//                {0,1},
//                {0,2},
//                {1,2}
//        };
        int[][] edges = new int[][] {
                {0,2},
                {0,5},
                {2,4},
                {1,6},
                {5,4}
        };
//        int[][] edges = new int[][] {
//                {1,0},
//                {3,1},
//                {0,4},
//                {2,1}
//        };

        long answer = countPairs(n, edges);
        System.out.println(answer);
    }

}
