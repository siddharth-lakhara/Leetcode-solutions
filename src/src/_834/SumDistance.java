package _834;

import java.util.*;

public class SumDistance {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        int[][] distanceMat = new int[n][n];
        List<List<Integer>> adjList = new ArrayList<>();
        for (int idx = 0; idx < n; idx++) {
            adjList.add(new ArrayList<>());
            distanceMat[idx][idx] = 0;
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        int startingNode = 0;
        for (int idx=0; idx<n; idx++) {
            if (adjList.get(idx).size() == 1) {
                startingNode = idx;
                break;
            }
        }

        Set<Integer> visitedNodes = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startingNode);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (visitedNodes.contains(node)) {
                continue;
            }

            List<Integer> neighbors = adjList.get(node);
            for (Integer neighbor : neighbors) {
                if (!visitedNodes.contains(neighbor)) {
                    queue.add(neighbor);
                    distanceMat[node][neighbor] = 1;
                    distanceMat[neighbor][node] = 1;
                }
                
                for (Integer visitedNode : visitedNodes) {
                    distanceMat[visitedNode][neighbor] = distanceMat[visitedNode][node] + 1;
                    distanceMat[neighbor][visitedNode] = distanceMat[visitedNode][node] + 1;
                }
            }

            visitedNodes.add(node);
        }







        return new int[]{};
    }

    public void driver() {
        int N = 6;
        int[][] edges = new int[][]{
                {0, 1}, {0,2}, {2,3},{2,4},{2,5}
        };

        int[] answer = sumOfDistancesInTree(N, edges);
        System.out.println(answer);
    }
}
