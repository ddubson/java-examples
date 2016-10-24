package com.ddubson.hackerrank.expert.savehumanity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by d.dubson on 2/12/2016.
 */
public class Solution {

	public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named RansomNote. */
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(r.readLine());

		for(int i = 0; i < testCases; i++) {
			String line = r.readLine();
			String fullDNA = line.split(" ")[0];
			String virusDNA = line.split(" ")[1];

			if(virusDNA.length() > fullDNA.length()) {
				System.out.println("No Match!");
			}

			List<Integer> startingIndicesOfMatches = new ArrayList<>();
			for(int c = 0; c < fullDNA.length() - (virusDNA.length() - 1); c++) {
				int duds = 0;

				if(!fullDNA.substring(c, virusDNA.length()-1).equals(virusDNA)) {
					for (int k = c, j = 0; j < virusDNA.length(); k++, j++) {
						if (fullDNA.charAt(k) != virusDNA.charAt(j)) {
							duds++;
						}

						if (duds > 1) {
							break;
						}
					}
				}

				if(duds < 2) {
					startingIndicesOfMatches.add(c);
				}
			}

			if(startingIndicesOfMatches.isEmpty()) {
				System.out.println("No Match!");
			} else {
				startingIndicesOfMatches.forEach(n -> { System.out.print(n + " "); });
				System.out.println();
			}
		}

	}
}
