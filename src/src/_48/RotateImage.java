package _48;

import java.util.Arrays;

public class RotateImage {

    public void rotate(int[][] matrix) {
        int colLength = matrix[0].length-1;
        for (int row = 0; row < matrix.length/2; row++) {

            for (int col=row; col <= colLength-(row+1); col++) {
                int sideRow = row;
                int sideCol = col;
                int last_element = matrix[row][col];
                for (int side=0; side<4; side++) {
                    int sideRow_next = sideCol;
                    int sideCol_next = colLength-sideRow;

                    int swap_cache = matrix[sideRow_next][sideCol_next];
                    matrix[sideRow_next][sideCol_next] = last_element;

                    last_element = swap_cache;
                    sideRow = sideRow_next;
                    sideCol = sideCol_next;
                }
            }
        }
    }
    
    public void driver() {
        int[][] matrix = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

}
