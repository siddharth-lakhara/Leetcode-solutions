package _695;

public class MaxAreaIsland {
    private int[][] grid;
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        int answer = 0;
        for (int row=0; row<grid.length; row++) {
            for (int col=0; col<grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    int area = markIsland(row, col, 0);
                    answer = Math.max(area, answer);
                }
            }
        }

        return answer;
    }

    public int markIsland(int row, int col, int areaCache) {
        if (row<0 || row>=grid.length || col<0 || col>=grid[0].length) {
            return areaCache;
        }

        if (grid[row][col] == 1) {
            grid[row][col] = 2;
            areaCache++;

//            mark up
            areaCache = markIsland(row-1, col, areaCache);
//            mark down
            areaCache = markIsland(row+1, col, areaCache);
//            mark left
            areaCache = markIsland(row, col-1, areaCache);
//            mark right
            areaCache = markIsland(row, col+1, areaCache);
        }

        return areaCache;
    }
    
    public void driver() {
        int[][] grid = new int[][] {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        int answer = maxAreaOfIsland(grid);
        System.out.println(answer);
    }
}
