package com.ddubson.hackerrank.moderate.onedarray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by d.dubson on 2/19/2016.
 */
public class Solution {
	enum Path {
		ONE,
		TWO,
		THREE
	}

	public static void main(String[] args) throws IOException {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(r.readLine());

		for (int i = 0; i < testCases; i++) {
			String line1 = r.readLine();
			int n = Integer.parseInt(line1.split(" ")[0]);
			int m = Integer.parseInt(line1.split(" ")[1]);

			String[] arrayStr = r.readLine().split(" ");
			int[] numArray = new int[n];
			for (int j = 0; j < n; j++) {
				numArray[j] = Integer.parseInt(arrayStr[j]);
			}

			int currentPos = 0;
			boolean haveWon = false;
			int interimPos = currentPos;
			Map<Integer, Set<Path>> pathsAttempted = new HashMap<>();
			while (true) {
				if (pathsAttempted.containsKey(interimPos)
						&& pathsAttempted.get(interimPos).size() == 3) {
					haveWon = false;
					break;
				} else {
					if (pathsAttempted.get(interimPos) == null) {
						pathsAttempted.put(interimPos, new HashSet<>());
					}
				}

				if (interimPos + m >= n || interimPos + 1 >= n) {
					haveWon = true;
					break;
				}

				if (!pathsAttempted.get(interimPos).contains(Path.THREE)
						&& numArray[interimPos + m] == 0) {
					pathsAttempted.get(interimPos).add(Path.THREE);
					interimPos += m;
					continue;
				} else {
					pathsAttempted.get(interimPos).add(Path.THREE);
				}

				if (!pathsAttempted.get(interimPos).contains(Path.TWO)
						&& numArray[interimPos + 1] == 0) {
					pathsAttempted.get(interimPos).add(Path.TWO);
					interimPos++;
					continue;
				} else {
					pathsAttempted.get(interimPos).add(Path.TWO);
				}

				if (!pathsAttempted.get(interimPos).contains(Path.ONE)
						&& interimPos - 1 >= 0
						&& numArray[interimPos - 1] == 0) {
					pathsAttempted.get(interimPos).add(Path.ONE);
					interimPos--;
					continue;
				} else {
					pathsAttempted.get(interimPos).add(Path.ONE);
				}

				haveWon = false;
				break;
			}

			if (haveWon) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}
