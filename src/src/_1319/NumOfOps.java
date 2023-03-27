package _1319;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NumOfOps {
    int[] parent;
    public int makeConnected(int n, int[][] connections) {
        parent = new int[n];
        Arrays.setAll(parent, p -> p);
        
        int reservedConn = 0;
        int distinctGroupsCount = 0;
        Set<Integer> distinctGroups = new HashSet<>();
        
        for (int[] conn : connections) {
            if (getParent(conn[0]) == getParent(conn[1])) {
                reservedConn++;
            } else {
                union(conn[0], conn[1]);
            }
        }

        for (int node : parent) {
            int p = getParent(node);
            if (!distinctGroups.contains(p)) {
                distinctGroups.add(p);
                distinctGroupsCount++;
            }
        }
        
        if (reservedConn >= distinctGroupsCount-1) {
            return distinctGroupsCount-1;
        } else {
            return -1;
        }
    }

    private void union(int src, int target) {
        int srcParent = getParent(src);
        int targetParent = getParent(target);
        
        parent[srcParent] = targetParent;
    }

    private int getParent(int node) {
        if (parent[node] == node) {
            return node;
        }
        return getParent(parent[node]);
    }

    public void driver() {
//        int n = 4;
//        int[][] connections = new int[][]{{0,1},{0,2},{1,2}};

//        int n = 6;
//        int[][] connections = new int[][]{{0,1},{0,2},{0,3},{1,2}};

//        int n = 5;
//        int[][] connections = new int[][]{{0,1},{0,2},{3,4},{2,3}};

        int n = 12;
        int[][] connections = new int[][]{{1,5},{1,7},{1,2},{1,4},{3,7},{4,7},{3,5},{0,6},{0,1},{0,4},{2,6},{0,3},{0,2}};
        
        int answer = makeConnected(n, connections);
        System.out.println(answer);
    }

}
