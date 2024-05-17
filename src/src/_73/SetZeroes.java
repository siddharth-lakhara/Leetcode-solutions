package _73;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetZeroes {
    public void setZeroes(int[][] matrix) {
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();
        for (int row = 0; row<matrix.length; row++) {
            for (int col=0; col< matrix[0].length; col++) {
                if (matrix[row][col] == 0) {
                    rowSet.add(row);
                    colSet.add(col);
                }
            }
        }

        for (int rowIdx: rowSet) {
            for (int col=0; col< matrix[0].length; col++) {
                matrix[rowIdx][col] = 0;
            }
        }

        for (int colIdx: colSet) {
            for (int row=0; row< matrix.length; row++) {
                matrix[row][colIdx] = 0;
            }
        }
    }

    public void driver() {
        int[][] matrix = new int[][]{
                {1, 1, 1}, {1, 0, 1}, {1, 1, 1}
        };
        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
