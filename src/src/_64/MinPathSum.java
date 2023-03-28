package _64;


import java.util.Arrays;

public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int[][] costMatrix = new int[grid.length][grid[0].length];
        for (int row = 0; row < costMatrix.length; row++) {
            Arrays.fill(costMatrix[row], Integer.MAX_VALUE);
        }
        costMatrix[0][0] = grid[0][0];
        
        for (int row = 0; row<grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (row+1<grid.length) {
                    costMatrix[row+1][col] = Math.min(
                            costMatrix[row+1][col],
                            costMatrix[row][col] + grid[row+1][col]
                    );
                }

                if (col+1<grid[0].length) {
                    costMatrix[row][col+1] = Math.min(
                            costMatrix[row][col+1],
                            costMatrix[row][col] + grid[row][col+1]
                    );
                }
            }
        }
        
        return costMatrix[grid.length-1][grid[0].length-1];
    }
    
    public void driver() {
        int[][] grid = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        
        int answer = minPathSum(grid);
        System.out.println(answer);
    }

}
