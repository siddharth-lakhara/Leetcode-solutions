package _240;

public class Search2DMatrix2OldSoln {
    int[][] matrix;
    int maxRow = 0;
    int maxCol = 0;
    int target;

    public boolean searchMatrix(int[][] matrix, int target) {
        this.matrix = matrix;
        this.maxRow = matrix.length;
        this.maxCol = matrix[0].length;
        this.target = target;

        return this.search(0, 0);
    }

    private boolean search(int currRow, int currCol) {
        if (matrix[currRow][currCol] == target) {
            return true;
        }

//        Go right
        boolean shouldGoRight = (currCol < maxCol-1) && (matrix[currRow][currCol+1] <= target);
        boolean foundRight = false;
        if (shouldGoRight) {
            foundRight = this.search(currRow, currCol+1);
        }
        if (foundRight) {
            return true;
        }

//        go down
        boolean shouldGoDown = (currRow < maxRow-1) && (matrix[currRow+1][currCol] <= target);
        if (shouldGoDown) {
            return this.search(currRow+1, currCol);
        }
        return false;
    }

    public void driver() {
        int[][] matrix = new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target = 5;
        boolean answer = this.searchMatrix(matrix, target);
        System.out.println(answer);
    }

}
