package _2360;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class LongestCycle {
    HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
    HashSet<Integer> visited = new HashSet<>();
    int maxLength = -1;
    
    public int longestCycle(int[] edges) {
        for (int src = 0; src < edges.length; src++) {
            if (!graph.containsKey(src)) {
                graph.put(src, new ArrayList<>());
            }
            graph.get(src).add(edges[src]);
        }

        for (int node = 0; node < edges.length; node++) {
            if (!visited.contains(node)) {
                evaluateCycle(node, new HashMap<>(), 0);    
            }
        }
        
        return maxLength;
    }

    private void evaluateCycle(int node, HashMap<Integer, Integer> path, int pathCounter) {
        path.put(node, pathCounter);

        if (graph.get(node) != null) {
            for (int neighbor : graph.get(node)) {
//            cycle found
                if (path.containsKey(neighbor)) {
                    int cycleLength = pathCounter - path.get(neighbor) + 1;
                    if (cycleLength > maxLength) {
                        maxLength = cycleLength;
                    }
                } else if (!visited.contains(neighbor)) {
                    evaluateCycle(neighbor, path, pathCounter+1);
                }
            }    
        }
        
        path.remove(node);
        visited.add(node);
    }

    public void driver() {
        int[] edges = new int[]{3,3,4,2,3};
        int answer = longestCycle(edges);
        System.out.println(answer);
    }
}
