package _417;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PacificAtlanticFlow {
    private record Coordinates(int x, int y){}
    private HashSet<Coordinates> pacificVisited;
    private HashSet<Coordinates> atlanticVisited;
    private int[][] heights;
    private int row;
    private int col;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        row = heights.length;
        col = heights[0].length;

        pacificVisited = new HashSet<>();
        atlanticVisited = new HashSet<>();

        for (int idx = 0; idx<col; idx++) {
            explorePacific(0, idx);
            exploreAtlantic(row-1, idx);
        }
        for (int idx = 0; idx<row; idx++) {
            explorePacific(idx, 0);
            exploreAtlantic(idx, col-1);
        }

        List<List<Integer>> answer = new ArrayList<>();
        for (Coordinates c: pacificVisited) {
            if (atlanticVisited.contains(c)) {
                answer.add(List.of(c.x, c.y));
            }
        }
        return answer;
    }

    private void explorePacific(int x, int y) {
        if (pacificVisited.contains(new Coordinates(x, y))) {
            return;
        }
        pacificVisited.add(new Coordinates(x, y));

//        explore up
        if (x-1>=0 && heights[x][y] <= heights[x-1][y]) {
            explorePacific(x-1, y);
        }

//        explore down
        if (x+1<row && heights[x][y] <= heights[x+1][y]) {
            explorePacific(x+1, y);
        }

//        explore left
        if (y-1>=0 && heights[x][y] <= heights[x][y-1]) {
            explorePacific(x, y-1);
        }
//        explore right
        if (y+1<col && heights[x][y] <= heights[x][y+1]) {
            explorePacific(x, y+1);
        }
    }

    private void exploreAtlantic(int x, int y) {
        if (atlanticVisited.contains(new Coordinates(x, y))) {
            return;
        }
        atlanticVisited.add(new Coordinates(x, y));

//        explore up
        if (x-1>=0 && heights[x][y] <= heights[x-1][y]) {
            exploreAtlantic(x-1, y);
        }

//        explore down
        if (x+1<row && heights[x][y] <= heights[x+1][y]) {
            exploreAtlantic(x+1, y);
        }

//        explore left
        if (y-1>=0 && heights[x][y] <= heights[x][y-1]) {
            exploreAtlantic(x, y-1);
        }
//        explore right
        if (y+1<col && heights[x][y] <= heights[x][y+1]) {
            exploreAtlantic(x, y+1);
        }
    }

    public void driver() {
        int[][] heights = new int[][]{
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };
        List<List<Integer>> answer = pacificAtlantic(heights);
        System.out.println(answer);
    }
}
