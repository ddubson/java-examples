package com.ddubson.algorithms.arrays;

import java.util.Scanner;

/**
 * Created by ddubs on 10/27/2016.
 */
public class GridlandMetro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numRows = scanner.nextInt();
        int numColumns = scanner.nextInt();
        int numTracks = scanner.nextInt();

        long totalLampPostSpots = numColumns * numRows;
        boolean[][] grid = new boolean[numRows][numColumns];

        for (int i = 0; i < numTracks; i++) {
            int row = scanner.nextInt()-1;
            int c1 = scanner.nextInt()-1;
            int c2 = scanner.nextInt()-1;

            long cellsForTracks = 0;
            for(int j = c1; j <= c2; j++) {
                if(!grid[row][j]) {
                    cellsForTracks++;
                    grid[row][j]=true;
                }
            }
            totalLampPostSpots -= cellsForTracks;
        }

        System.out.println(totalLampPostSpots);
    }
}
