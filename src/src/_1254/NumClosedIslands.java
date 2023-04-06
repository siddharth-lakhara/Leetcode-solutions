package _1254;

public class NumClosedIslands {
    private enum Status {
        LAND(0),
        WATER(1),
        OPEN(2),
        CLOSED(3),
        UNKNOWN(4),
        PROCESSING(5);
        
        private int topography;
        Status(int topography) {
            this.topography = topography;
        }
    };
    
    private int[][] grid;
    public int closedIsland(int[][] grid) {
        this.grid = grid;
        int answer = 0;
        for (int rowIdx = 0; rowIdx < grid.length; rowIdx++) {
            for (int colIdx = 0; colIdx < grid[rowIdx].length; colIdx++) {
                if (grid[rowIdx][colIdx] == Status.LAND.topography) {
                    Status islandStatus = checkClosedIsland(rowIdx, colIdx);
                    if (islandStatus == Status.CLOSED) {
                        answer++;
                    }
                    floodFillStatus(rowIdx, colIdx, islandStatus);
                }
                
            }
        }
        
        return answer;
    }

    private void floodFillStatus(int rowIdx, int colIdx, Status status) {
        if (colIdx<0 || colIdx>=grid[0].length || rowIdx<0 || rowIdx>=grid.length) {
            return;
        }
        
        if (grid[rowIdx][colIdx] != Status.WATER.topography &&
                grid[rowIdx][colIdx] != status.topography) {
            grid[rowIdx][colIdx] = status.topography;
            floodFillStatus(rowIdx-1, colIdx, status);
            floodFillStatus(rowIdx+1, colIdx, status);
            floodFillStatus(rowIdx, colIdx-1, status);
            floodFillStatus(rowIdx, colIdx+1, status);
        }
    }

    private Status checkClosedIsland(int rowIdx, int colIdx) {
        Status islandTopography = Status.values()[grid[rowIdx][colIdx]];
        switch (islandTopography) {
            case WATER:
            case CLOSED:
            case PROCESSING:
            case UNKNOWN:
                return Status.CLOSED;
            case OPEN:
                return Status.OPEN;
        }
             
        grid[rowIdx][colIdx] = Status.PROCESSING.topography;

//        Boundary
        if (colIdx-1 < 0 || colIdx+1>=grid[0].length || rowIdx-1 <0 || rowIdx+1>=grid.length) {
            return Status.OPEN;
        }
        
//        check left
        Status leftStatus = checkClosedIsland(rowIdx, colIdx-1);
        if (leftStatus == Status.OPEN) {
            return Status.OPEN;
        }
        
//        check top
        Status topStatus = checkClosedIsland(rowIdx-1, colIdx);
        if (topStatus == Status.OPEN) {
            return Status.OPEN;
        }
        
//        check right
        Status rightStatus = checkClosedIsland(rowIdx, colIdx+1);
        if (rightStatus == Status.OPEN) {
            return Status.OPEN;
        }
        
//        check bottom
        Status bottomStatus = checkClosedIsland(rowIdx+1, colIdx);
        if (bottomStatus == Status.OPEN) {
            return Status.OPEN;
        }
        
        grid[rowIdx][colIdx] = Status.UNKNOWN.topography;
        return Status.CLOSED;
    }

    public void driver() {
//        int[][] grid = new int[][]{
//                {1,1,1,1,1,1,1,0},
//                {1,0,0,0,0,1,1,0},
//                {1,0,1,0,1,1,1,0},
//                {1,0,0,0,0,1,0,1},
//                {1,1,1,1,1,1,1,0}
//        };
        
//        int[][] grid = new int[][]{
//                {0,0,1,0,0},
//                {0,1,0,1,0},
//                {0,1,1,1,0}
//        };

        int[][] grid = new int[][]{
                {1,1,0,1,1,1,1,1,1,1},
                {0,0,1,0,0,1,0,1,1,1},
                {1,0,1,0,0,0,1,0,1,0},
                {1,1,1,1,1,0,0,1,0,0},
                {1,0,1,0,1,1,1,1,1,0},
                {0,0,0,0,1,1,0,0,0,0},
                {1,0,1,0,0,0,0,1,1,0},
                {1,1,0,0,1,1,0,0,0,0},
                {0,0,0,1,1,0,1,1,1,0},
                {1,1,0,1,0,1,0,0,1,0}
        };
        int answer = closedIsland(grid);
        System.out.println(answer);
    }
}
