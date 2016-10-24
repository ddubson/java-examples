package com.ddubson.algorithms.dynamic_programming;

/**
 * Created by ddubs on 10/24/2016.
 */
public class UniquePaths {
    /*
    A robot is located at the top-left corner of a m x n grid. It can only move either down or right at any point in time. \
    The robot is trying to reach the bottom-right corner of the grid.
    How many possible unique paths are there?

    Constraints:
        Start at 0,0 position
        End at m-1 x n-1 position (e.g. 3x3 grid, return unique paths to get to 2x2 factoring in index offset)
        if m x n is 0x0 return 0 if 1x1 return 1 since its start and end;
     */
    public static int paths(int x, int y) {
        if(x == 0 || y == 0)
            return 0;
        if(x == 1 || y == 1)
            return 1;

        // Create memoization grid
        int[][] paths = new int[x][y];

        // Record for X-axis one unique path
        for (int i = 0; i < x; i++) {
            paths[i][0] = 1;
        }

        // Record Y-axis one unique path
        for (int i = 0; i < y; i++) {
            paths[0][i] = 1;
        }

        // For each cell greater than row, col 1, calculate paths
        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                 paths[i][j] = paths[i-1][j]+paths[i][j-1];
            }
        }

        return paths[x-1][y-1];
    }
}
