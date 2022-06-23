package _1642;

import java.util.PriorityQueue;

public class FurthestBuilding {

    private int solve(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int bricksUsed = 0;
        int i = 1;
        for (; i<heights.length; i++) {
              int diff = heights[i] - heights[i-1];
              if (diff>0) {
                  pq.add(diff);
                  if(pq.size() > ladders) {
                      bricksUsed += pq.remove();
                  }

                  if (bricksUsed > bricks) {
                      return i-1;
                  }
              }
        }
        return heights.length-1;
    }

    public void driver() {
        int[] heights = new int[]{14,3,19,3};
        int bricks = 17;
        int ladders = 0;

        int answer = this.solve(heights, bricks, ladders);

        System.out.println(answer);
    }

}
