package _684;

import java.util.Arrays;

public class RedundantConnection {
    int[] parent;

    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length+1];
        Arrays.setAll(parent, i -> i);

        int[] cycle = new int[2];
        for (int[] edge: edges) {
            boolean isSuccessful = union(edge[0], edge[1]);
            if (!isSuccessful) {
                cycle = edge;
                break;
            }
        }

        return cycle;
    }

    private boolean union(int node1, int node2) {
        int parent1 = findParent(node1);
        int parent2 = findParent(node2);

        if (parent1 == parent2) {
            return false;
        }

        parent[parent1] = parent2;
        return true;
    }

    private int findParent(int node) {
        if (parent[node] == node) {
            return node;
        }

        parent[node] = findParent(parent[node]);
        return parent[node];
    }

    public void driver() {
//        int[][] edges = new int [][]{
//                {1,2},
//                {2,3},
//                {3,4},
//                {1,4},
//                {1,5}
//        };
        int[][] edges = new int[][] {{1,2},{1,3},{2,3}};
        int[] answer = findRedundantConnection(edges);
        System.out.println(Arrays.toString(answer));
    }
}
