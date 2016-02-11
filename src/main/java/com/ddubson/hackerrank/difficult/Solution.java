package com.ddubson.hackerrank.difficult;

import java.io.*;
import java.util.*;

public class Solution {
	static int lastans = 0;

	public static int findSequence(int x, int lastans, int numberOfSequences) {
		return (x ^ lastans) % numberOfSequences;
	}

	public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		String firstLine = r.readLine();
		int numberOfSequences = Integer.parseInt(firstLine.split(" ")[0]);
		int numberOfQueries = Integer.parseInt(firstLine.split(" ")[1]);
		Map<Integer,List<Integer>> sequences = new HashMap<>();

		for(int i = 0; i < numberOfQueries; i++) {
			String[] fullQuery = r.readLine().split(" ");
			List<Integer> seq;
			if(Integer.parseInt(fullQuery[0]) == 1) {
				int seqKey = findSequence(Integer.parseInt(fullQuery[1]), lastans, numberOfSequences);
				seq = sequences.get(seqKey);
				if(seq == null) {
					seq = new ArrayList<>();
				}

				seq.add(Integer.parseInt(fullQuery[2]));
				sequences.put(seqKey,seq);
			}

			if(Integer.parseInt(fullQuery[0]) == 2) {
				seq = sequences.get(findSequence(Integer.parseInt(fullQuery[1]), lastans, numberOfSequences));
				System.out.println(seq.get(Integer.parseInt(fullQuery[2]) % seq.size()));
				lastans = seq.size();
			}
		}

	}
}
