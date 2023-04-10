package _1857;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class LargestColorValue {
    
    private HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>(); 
    private int globalMax = 0;
    private HashSet<Integer> visitedNodes = new HashSet<>();
    private HashMap<Integer, HashMap<Character, Integer>> cache = new HashMap<>();
    private String colors;
    
    public int largestPathValue(String colors, int[][] edges) {
        this.colors = colors;
        
//        build graph
        for (int[] e : edges) {
            if (!graph.containsKey(e[0])) {
                 graph.put(e[0], new ArrayList<>());
                 cache.put(e[0], new HashMap<>());
            }
            
            graph.get(e[0]).add(e[1]);
        }

        for (int node = 0; node < colors.length(); node++) {
            if (!visitedNodes.contains(node)) {
                if (evaluateColors(node, new HashSet<>()) == -1) {
                    return -1;
                }
            }
        }
        
        return globalMax;
    }
    
    private int evaluateColors(int node, HashSet<Integer> path) {
//        System.out.println("Start exploring node: " + node);
        path.add(node);
        ArrayList<Integer> neighbors = graph.get(node);
        
        if (!cache.containsKey(node)) {
            cache.put(node, new HashMap<>());
        }
        HashMap<Character, Integer> currentNodeCache = cache.get(node);

        if (neighbors != null) {
            for (Integer neighbor : neighbors) {
//            cycle found
                if (path.contains(neighbor)) {
                    return -1;
                }

//            core logic = update cache
                if (!visitedNodes.contains(neighbor)) {
                    if (evaluateColors(neighbor, path) == -1) {
                        return -1;
                    }
                }

                HashMap<Character, Integer> neighborNodeCache = cache.get(neighbor);
                for (Character color : neighborNodeCache.keySet()) {
                    currentNodeCache.put(color, Math.max(
                            neighborNodeCache.get(color),
                            currentNodeCache.getOrDefault(color, 0)
                    ));
                }
            }    
        }
        
//        update current node's color in cache
        char currentColor = colors.charAt(node);
        int localMax = currentNodeCache.getOrDefault(currentColor, 0) + 1;
        currentNodeCache.put(currentColor, localMax);
        if (localMax > globalMax) {
//            System.out.println("Setting new maxima from node: " + node + " with color: " + currentColor);
            globalMax = localMax;
        }

//        System.out.println("Explored all neighbors of node: " + node);
        //        plumbing
        visitedNodes.add(node);
        path.remove(node);
        
        return 0;
    }
    
    public void driver() {
//        String colors = "abaca";
//        int[][] edges = new int[][] {
//                {0,1},
//                {0,2},
//                {2,3},
//                {3,4}  
//        };

        String colors = "hhqhuqhqff";
        int[][] edges = new int[][] {
                {0,1},
                {0,2},
                {2,3},
                {3,4},
                {3,5},
                {5,6},
                {2,7},
                {6,7},
                {7,8},
                {3,8},
                {5,8},
                {8,9},
                {3,9},
                {6,9}
        };
        
        int answer = largestPathValue(colors, edges);
        System.out.println(answer);
    }

}
