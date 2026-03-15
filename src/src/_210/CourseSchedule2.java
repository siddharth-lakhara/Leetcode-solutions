package _210;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CourseSchedule2 {
    private enum NodeStatus {
        WHITE,
        BLACK,
        GRAY
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        NodeStatus[] visited = new NodeStatus[numCourses];
        Arrays.fill(visited, NodeStatus.WHITE);

        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
        for (int node=0; node<numCourses; node++) {
            adjList.put(node, new ArrayList<>());
        }

        for (int[] edge: prerequisites) {
            adjList.get(edge[0]).add(edge[1]);
        }

        ArrayList<Integer> order =  new ArrayList<>();
        for (int node=0; node<numCourses; node++) {
            if (!exploreNode(node, adjList, visited, order)) {
                order.clear();
                break;
            }
        }
//        convert order to array
        return order.stream()
                .mapToInt(i -> i) // or Integer::intValue
                .toArray();
    }

    private boolean exploreNode(int node, HashMap<Integer, ArrayList<Integer>> adjList, NodeStatus[] visited, ArrayList<Integer> order) {
        if (visited[node] == NodeStatus.GRAY) {
            return false;
        } else if (visited[node] == NodeStatus.BLACK) {
            return true;
        }

        visited[node] = NodeStatus.GRAY;
        for (int neighbor: adjList.get(node)) {
            if (!exploreNode(neighbor, adjList, visited, order)) {
                return false;
            }
        }

        visited[node] = NodeStatus.BLACK;
        order.add(node);

        return true;
    }

    public void driver() {
        int numCourses = 1;
        int[][] prerequisites = new int[][]{};
        int[] answer = findOrder(numCourses, prerequisites);
        System.out.println(Arrays.toString(answer));
    }
}
