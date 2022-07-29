package _733;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        fill(image, sr, sc, oldColor, newColor);
        return image;
    }

    private void fill(int[][] image, int sr, int sc, int oldColor, int newColor) {
        if(sc < 0 || sc >= image[0].length || sr < 0 || sr >= image.length || image[sr][sc] != oldColor || image[sr][sc] == newColor) {
            return ;
        }
        image[sr][sc] = newColor;
        fill(image, sr+1, sc, oldColor, newColor);
        fill(image, sr-1, sc, oldColor, newColor);
        fill(image, sr, sc+1, oldColor, newColor);
        fill(image, sr, sc-1, oldColor, newColor);
    }

    public void driver() {
        int[][] image = new int[][]{
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int sr = 1, sc = 1, color = 2;
        floodFill(image, sr, sc, color);
    }
}
