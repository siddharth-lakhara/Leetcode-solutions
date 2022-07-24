package _74;

public class Search2DMatrix {

    private boolean solve(int[][] matrix, int target) {
        boolean found = false;
        int maxRow = matrix.length;
        int maxCol = matrix[0].length;
        int currRow = 0;
        int currCol = 0;

        while (currRow < maxRow - 1) {
            if (matrix[currRow + 1][0] <= target) {
                currRow++;
            } else {
                break;
            }
        }
        if (matrix[currRow][maxCol - 1] < target) {
            return false;
        }

        while (currCol < maxCol) {
            if (matrix[currRow][currCol] == target) {
                found = true;
                break;
            } else if (matrix[currRow][currCol] < target) {
                currCol++;
            } else {
                break;
            }
        }

        return found;
    }

    public void driver() {
        int[][] matrix = new int[][]{{1}, {3}};
        int target = 3;
        boolean answer = this.solve(matrix, target);
        System.out.println(answer);
    }

}
