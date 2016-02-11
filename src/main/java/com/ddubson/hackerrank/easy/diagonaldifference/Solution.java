package com.ddubson.hackerrank.easy.diagonaldifference;

import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		final int n = Integer.valueOf(r.readLine());
		int[][] matrix = new int[n][n];
		for(int k = 0; k < n; k++) {
			String[] line = r.readLine().split(" ");
			for(int m = 0; m < n; m++) {
				matrix[k][m] = Integer.valueOf(line[m]);
			}
		}

		int sumFirstDiaganol = 0;
		int sumSecondDiaganol = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(j == i) {
					sumFirstDiaganol+=matrix[i][j];
				}

				if(j == n-(i+1)) {
					sumSecondDiaganol+=matrix[i][j];
				}
			}
		}

		System.out.println(Math.abs(sumFirstDiaganol - sumSecondDiaganol));
	}
}