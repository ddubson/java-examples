package com.ddubson.hackerrank.easy.bigsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named RansomNote. */
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		r.readLine();
		StringTokenizer s = new StringTokenizer(r.readLine());
		long sum = 0;
		while(s.hasMoreTokens()) {
			sum += Long.valueOf(s.nextToken());
		}
		System.out.print(sum);
	}
}
