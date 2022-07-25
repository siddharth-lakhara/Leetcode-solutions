package _240;

public class Search2DMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int maxRow = matrix.length;
        int maxCol = matrix[0].length;

        int currRow = 0;
        int currCol = maxCol-1;

        while (currRow < maxRow && currCol >= 0) {
            if (matrix[currRow][currCol] == target) {
                return true;
            }

            if (matrix[currRow][currCol] > target) {
                currCol--;
            } else {
                currRow++;
            }
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
