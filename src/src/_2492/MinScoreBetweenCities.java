package _2492;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class MinScoreBetweenCities {

    private class GraphNode {
        HashSet<Integer> neighbors;
        int minScore;
        
        public GraphNode() {
            neighbors = new HashSet<>();
            minScore = Integer.MAX_VALUE;
        }
        
        public void addNode(int neighbor, int weight) {
            if (weight < minScore) {
                minScore = weight;
            }
            neighbors.add(neighbor);
        }
    }
    
    public int minScore(int n, int[][] roads) {
        HashMap<Integer, GraphNode> graph = new HashMap<>();
        for (int[] road : roads) {
            int src = road[0];
            int target = road[1];
            int weight = road[2];
            
            if (!graph.containsKey(src)) {
                graph.put(src, new GraphNode());
            }
            graph.get(src).addNode(target, weight);

            if (!graph.containsKey(target)) {
                graph.put(target, new GraphNode());
            }
            graph.get(target).addNode(src, weight);
        }
        
        int globalMin = Integer.MAX_VALUE;
        HashSet<Integer> visitedNodes = new HashSet<>();

        LinkedList<Integer> nodesToVisit = new LinkedList<>();
        nodesToVisit.add(1);
        
        while (nodesToVisit.size() > 0) {
            int node = nodesToVisit.pop();
            if (visitedNodes.contains(node)) {
                continue;
            }
            
            visitedNodes.add(node);
            globalMin = Math.min(globalMin, graph.get(node).minScore);

            for (Integer neighbor : graph.get(node).neighbors) {
                if (!visitedNodes.contains(neighbor)) {
                    nodesToVisit.add(neighbor);
                }
            }
        }
        
        return globalMin;
    }
    
    public void driver() {
        int n = 4;
//        int[][] roads = new int[][]{
//                {1,2,2},
//                {1,3,4},
//                {3,4,7}
//        };
        int[][] roads = new int[][]{
                {1,2,9},
                {2,3,6},
                {2,4,5},
                {1,4,7}
        };
        int answer = minScore(n, roads);
        System.out.println(answer);
    }

}
