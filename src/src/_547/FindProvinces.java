package _547;

public class FindProvinces {
    public int findCircleNum(int[][] isConnected) {
        int count = isConnected.length;

        int[] parents = new int[isConnected.length];
        for (int i=0; i<parents.length; i++) {
            parents[i] = i;
        }

        for (int source=0; source<isConnected.length; source++) {
            for (int target=source+1; target<isConnected.length; target++) {
                if (isConnected[source][target] == 1) {
                    int p1 = findParents(source, parents);
                    int p2 = findParents(target, parents);

                    if (p2 != p1) {
                        parents[p2] = p1;
                        count--;
                    }
                }
            }
        }

        return count;
    }

    private int findParents(int node, int[] parents) {
        if (parents[node] != node) {
            parents[node] = findParents(parents[node], parents);
        }

        return parents[node];
    }

    public void driver() {
        int[][] isConnected = new int[][]
                {
                        {1,1,1,0,1,1,1,0,0,0},
                        {1,1,0,0,0,0,0,1,0,0},
                        {1,0,1,0,0,0,0,0,0,0},
                        {0,0,0,1,1,0,0,0,1,0},
                        {1,0,0,1,1,0,0,0,0,0},
                        {1,0,0,0,0,1,0,0,0,0},
                        {1,0,0,0,0,0,1,0,1,0},
                        {0,1,0,0,0,0,0,1,0,1},
                        {0,0,0,1,0,0,1,0,1,1},
                        {0,0,0,0,0,0,0,1,1,1}
                };
        int answer = findCircleNum(isConnected);
        System.out.println(answer);
    }
}
