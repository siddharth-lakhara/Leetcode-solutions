package _210;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class CourseSchedule2 {
    private enum NodeStatus {
        WHITE,
        BLACK,
        GRAY
    }

    private NodeStatus[] nodeStatusArr;
    private HashMap<Integer, ArrayList<Integer>> adjList;
    private Stack<Integer> visitedStack;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        visitedStack = new Stack<>();
        nodeStatusArr = new NodeStatus[numCourses];
        Arrays.fill(nodeStatusArr, NodeStatus.WHITE);

        adjList = new HashMap<>();

        for (int[] edge: prerequisites) {
            if (!adjList.containsKey(edge[1])) {
                adjList.put(edge[1], new ArrayList<>());
            }
            adjList.get(edge[1]).add(edge[0]);
        }

        for (int i=0; i<nodeStatusArr.length; i++) {
            if (nodeStatusArr[i] == NodeStatus.WHITE) {
                if (exploreNode(i)) {
                    return new int[]{};
                }
            }
        }

//        stack to list conversion
        int[] answer = new int[numCourses];
        int idx = 0;
        while (!visitedStack.isEmpty()) {
            answer[idx] = visitedStack.pop();
            idx++;
        }
        return answer;
    }

//    explores all the neighbors of node.
//    Returns true if a cycle is detected, otherwise false
    private boolean exploreNode(int node) {
        if (nodeStatusArr[node] == NodeStatus.GRAY) {
            return true;
        } else if (nodeStatusArr[node] == NodeStatus.BLACK) {
            return false;
        } else if (!adjList.containsKey(node)) {
            nodeStatusArr[node] = NodeStatus.BLACK;
            visitedStack.push(node);
            return false;
        }

        nodeStatusArr[node] = NodeStatus.GRAY;
        ArrayList<Integer> neighbors = adjList.get(node);
        for (int n: neighbors) {
            if (exploreNode(n)) {
                return true;
            }
        }
        nodeStatusArr[node] = NodeStatus.BLACK;
        visitedStack.push(node);
        return false;
    }

    public void driver() {
        int numCourses = 1;
        int[][] prerequisites = new int[][]{};
        int[] answer = findOrder(numCourses, prerequisites);
        System.out.println(Arrays.toString(answer));
    }
}
