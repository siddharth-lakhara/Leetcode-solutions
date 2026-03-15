package _417;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticFlow {
    private static class CacheNode {
        public boolean isPacificReachable;
        public boolean isAtlanticReachable;

        public CacheNode() {
            this.isPacificReachable = false;
            this.isAtlanticReachable = false;
        }
    }

    private enum Conditions {
        pacific,
        atlantic
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length;
        int COLS = heights[0].length;

        CacheNode[][] cache =  new CacheNode[ROWS][COLS];
        for (int r = 0; r<ROWS; r++) {
            for (int c = 0; c<COLS; c++) {
                cache[r][c] = new CacheNode();
            }
        }

        for (int idx = 0; idx < COLS; idx++) {
            exploreSurroundings(0, idx, heights, cache, Conditions.pacific);
            exploreSurroundings(ROWS-1, idx, heights, cache, Conditions.atlantic);
        }
        for (int idx = 0; idx < ROWS; idx++) {
            exploreSurroundings(idx, 0, heights, cache, Conditions.pacific);
            exploreSurroundings(idx, COLS-1, heights, cache, Conditions.atlantic);
        }

        List<List<Integer>> answer = new ArrayList<>();
        for (int r = 0; r<ROWS; r++) {
            for (int c = 0; c<COLS; c++) {
                if (cache[r][c].isPacificReachable && cache[r][c].isAtlanticReachable) {
                    answer.add(new ArrayList<>(
                            Arrays.asList(r, c)
                    ));
                }
            }
        }
        return answer;
    }

    private void exploreSurroundings(int r, int c, int[][] heights, CacheNode[][] cache, Conditions condition) {
        if (condition == Conditions.pacific) {
            if (cache[r][c].isPacificReachable) {
                return;
            }

            cache[r][c].isPacificReachable = true;
        } else {
            if (cache[r][c].isAtlanticReachable) {
                return;
            }

            cache[r][c].isAtlanticReachable = true;
        }


//        explore up
        if (r-1>=0 && heights[r][c] <= heights[r-1][c]) {
            exploreSurroundings(r-1, c, heights, cache, condition);
        }

//        explore down
        if (r+1<heights.length && heights[r][c] <= heights[r+1][c]) {
            exploreSurroundings(r+1, c, heights, cache, condition);
        }

//        explore left
        if (c-1>=0 && heights[r][c] <= heights[r][c-1]) {
            exploreSurroundings(r, c-1, heights, cache, condition);
        }
//        explore right
        if (c+1<heights[0].length && heights[r][c] <= heights[r][c+1]) {
            exploreSurroundings(r, c+1, heights, cache, condition);
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
