package _378;

public class KthSmallestInSpiralMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int min = matrix[0][0];
        int max = matrix[n - 1][n - 1];

        while (min <= max) {
            int mid = min + ((max - min) >> 1);
            int count = countSmaller(matrix, mid);
            if (count < k) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        return min;
    }

    private static int countSmaller(int[][] matrix, int target) {
        int n = matrix.length;
        int col = n - 1;
        int row = 0;
        int count = 0;
        while (col >= 0 && row < n) {
            if (matrix[col][row] > target) {
                col--;
            } else {
                count += col + 1;
                row++;
            }
        }

        return count;
    }

    public void driver() {
        int[][] nums = new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        int k = 8;
        int answer = this.kthSmallest(nums, k);
        System.out.println(answer);
    }

}
