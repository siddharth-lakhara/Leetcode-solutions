package _994;

import java.util.*;

public class RottingOranges {
    private record Coordinates(int x, int y) {};
    private Queue<Coordinates> rottenCoordinates;
    private int goodOranges;
    private int[][] grid;

    public int orangesRotting(int[][] grid) {
        rottenCoordinates = new LinkedList<>();
        goodOranges = 0;
        this.grid = grid;

        for (int row=0; row<grid.length; row++) {
            for (int col=0; col<grid[0].length; col++) {
                if (grid[row][col] == 2) {
                    rottenCoordinates.add(new Coordinates(row, col));
                } else if (grid[row][col] == 1) {
                    goodOranges++;
                }
            }
        }

        int answer = -1;
        while (!rottenCoordinates.isEmpty()) {
            recursiveRot(rottenCoordinates.size());
            answer++;
        }

        if (goodOranges > 0) {
            return -1;
        }
        return Math.max(answer, 0);
    }

    private void recursiveRot(int size) {
        while (size > 0) {
            size--;
            Coordinates rottenOrange = rottenCoordinates.remove();

//            rot up
            if (rottenOrange.x > 0) {
                rot(rottenOrange.x-1, rottenOrange.y);
            }

//            rot down
            if (rottenOrange.x < grid.length-1) {
                rot(rottenOrange.x+1, rottenOrange.y);
            }

//            rot left
            if (rottenOrange.y > 0) {
                rot(rottenOrange.x, rottenOrange.y-1);
            }

//            rot right
            if (rottenOrange.y < grid[0].length-1) {
                rot(rottenOrange.x, rottenOrange.y+1);
            }
        }
    }

    private void rot(int x, int y) {
        if (grid[x][y] == 1) {
            grid[x][y] = 2;
            rottenCoordinates.add(new Coordinates(x, y));
            goodOranges--;
        }
    }

    public void driver() {
//        int[][] grid = new int[][]{
//            {2,1,1},
//            {1,1,0},
//            {0,1,1}
//        };

        int[][] grid = new int[][]{
                {2,1,1},
                {0,1,1},
                {1,0,1}
        };

        int answer = orangesRotting(grid);
        System.out.println(answer);
    }
}
