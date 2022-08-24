package _200;

public class NumberOfIslands {
    private char[][] grid;

    public int numIslands(char[][] grid) {
        int count = 0;
        this.grid = grid;
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[x][y] == '1') {
                    count++;
                    markIsland(x, y);
                }
            }
        }
        return count;
    }

    private void markIsland(int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return;
        }
        if (grid[x][y] == '1') {
            grid[x][y] = '2';
            markIsland(x - 1, y);
            markIsland(x + 1, y);
            markIsland(x, y - 1);
            markIsland(x, y + 1);
        }
    }

    public void driver() {
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        int answer = numIslands(grid);
        System.out.println(answer);
    }
}
