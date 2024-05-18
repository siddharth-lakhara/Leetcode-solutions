package _207;

import _206.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CourseSchedule {
    private enum NodeStatus {
        WHITE,
        BLACK,
        GRAY
    }

    private NodeStatus[] nodeStatusArr;
    private HashMap<Integer, ArrayList<Integer>> adjList;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        nodeStatusArr = new NodeStatus[numCourses];
        Arrays.fill(nodeStatusArr, NodeStatus.WHITE);

        adjList = new HashMap<>();

        for (int[] edge: prerequisites) {
            if (!adjList.containsKey(edge[0])) {
                adjList.put(edge[0], new ArrayList<>());
            }
            adjList.get(edge[0]).add(edge[1]);
        }

        for (int i=0; i<nodeStatusArr.length; i++) {
            if (nodeStatusArr[i] == NodeStatus.WHITE) {
                if (detectCycle(i)) {
                    return false;
                }
            }
        }

        return true;

    }

    private boolean detectCycle(int node) {
        if (nodeStatusArr[node] == NodeStatus.GRAY) {
            return true;
        } else if (nodeStatusArr[node] == NodeStatus.BLACK) {
            return false;
        } else if (!adjList.containsKey(node)) {
            nodeStatusArr[node] = NodeStatus.BLACK;
            return false;
        }

        nodeStatusArr[node] = NodeStatus.GRAY;
        ArrayList<Integer> neighbors = adjList.get(node);
        for (int n: neighbors) {
            if (detectCycle(n)) {
                return true;
            }
        }
        nodeStatusArr[node] = NodeStatus.BLACK;
        return false;
    }

    public void driver() {
        int numCourses = 2;
        int[][] prerequisites = new int[][]{{1,0}, {0,1}};
        boolean answer = canFinish(numCourses, prerequisites);
        System.out.println(answer);
    }
}
