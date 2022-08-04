package _54;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT,
}

public class SpiralMatrix {

    private final HashMap<Direction, Direction> nextDirectionMap = new HashMap<>() {{
        put(Direction.UP, Direction.RIGHT);
        put(Direction.RIGHT, Direction.DOWN);
        put(Direction.DOWN, Direction.LEFT);
        put(Direction.LEFT, Direction.UP);
    }};
    int top;
    int bottom;
    int left;
    int right;

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList<>();
        Direction currDirection = Direction.RIGHT;

        this.top = 0;
        this.bottom = matrix.length;
        this.left = 0;
        this.right = matrix[0].length;

        boolean shouldGoOn = true;
        while (shouldGoOn) {
            if (currDirection == Direction.RIGHT) {
                shouldGoOn = goRight(answer, matrix);
            } else if (currDirection == Direction.LEFT) {
                shouldGoOn = goLeft(answer, matrix);
            } else if (currDirection == Direction.UP) {
                shouldGoOn = goUp(answer, matrix);
            } else {
                shouldGoOn = goDown(answer, matrix);
            }
//            get next direction
            currDirection = nextDirectionMap.get(currDirection);
        }

        return answer;
    }

    private boolean goRight(List<Integer> answer, int[][] matrix) {
        for (int idx = left; idx < right; idx++) {
            answer.add(matrix[top][idx]);
        }
        top++;
        return top < bottom;
    }

    private boolean goLeft(List<Integer> answer, int[][] matrix) {
        for (int idx = right - 1; idx >= left; idx--) {
            answer.add(matrix[bottom - 1][idx]);
        }
        bottom--;
        return top < bottom;
    }

    private boolean goUp(List<Integer> answer, int[][] matrix) {
        for (int idx = bottom - 1; idx >= top; idx--) {
            answer.add(matrix[idx][left]);
        }
        left++;
        return left < right;
    }

    private boolean goDown(List<Integer> answer, int[][] matrix) {
        for (int idx = top; idx < bottom; idx++) {
            answer.add(matrix[idx][right-1]);
        }
        right--;
        return left < right;
    }

    public void driver() {
        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> answer = this.spiralOrder(matrix);
        System.out.println(answer);
    }

}
