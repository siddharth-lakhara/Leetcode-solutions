package _1020;

public class NumEnclaves {
    public int numEnclaves(int[][] grid) {
        int answer = 0;
        
        for (int col = 0; col < grid[0].length; col++) {
            if (grid[0][col] == 1) {
                markEnclave(0, col, grid);
            }
            if (grid[grid.length-1][col] == 1) {
                markEnclave(grid.length-1, col, grid);
            }
        }

        for (int row = 1; row < grid.length-1; row++) {
            if (grid[row][0] == 1) {
                markEnclave(row, 0, grid);
            }
            if (grid[row][grid[0].length-1] == 1) {
                markEnclave(row, grid[0].length-1, grid);
            }
        }

        for (int row = 1; row < grid.length-1; row++) {
            for (int col = 1; col < grid[0].length-1; col++) {
                if (grid[row][col] == 1) {
                    answer++;
                }
            }
        }
        
        return answer;
    }

    private void markEnclave(int row, int col, int[][] grid) {
//        boundary
        if (row<0 || col<0 || row>=grid.length || col>=grid[0].length) {
            return ;
        }
        
        if (grid[row][col] == 1) {
            grid[row][col] = 2;
            markEnclave(row, col-1, grid);
            markEnclave(row, col+1, grid);
            markEnclave(row+1, col, grid);
            markEnclave(row-1, col, grid);
        }
    }

    public void driver() {
        int[][] grid = new int[][] {
                {0,0,0,0},
                {1,0,1,0},
                {0,1,1,0},
                {0,0,0,0}
        };
        int answer = numEnclaves(grid);
        System.out.println(answer);
    }
}
