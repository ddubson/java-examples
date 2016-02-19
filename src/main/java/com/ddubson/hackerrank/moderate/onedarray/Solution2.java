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
public class Solution2 {
	enum Path {
		ONE,
		TWO,
		THREE
	}

	static class TreeNode {
		int val;
		TreeNode moveMinusOne;
		TreeNode movePlusOne;
		TreeNode movePlusM;
		boolean isWin;

		public TreeNode(int val) {
			this.val = val;
		}

		public TreeNode(boolean isWin) {
			this.isWin = isWin;
		}

		public boolean isWinning() {
			return isWin;
		}

		public TreeNode getMoveMinusOne() {
			return moveMinusOne;
		}

		public void setMoveMinusOne(TreeNode moveMinusOne) {
			this.moveMinusOne = moveMinusOne;
		}

		public TreeNode getMovePlusOne() {
			return movePlusOne;
		}

		public void setMovePlusOne(TreeNode movePlusOne) {
			this.movePlusOne = movePlusOne;
		}

		public TreeNode getMovePlusM() {
			return movePlusM;
		}

		public void setMovePlusM(TreeNode movePlusM) {
			this.movePlusM = movePlusM;
		}
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

			// Create Tree
			Map<Integer, TreeNode> subTrees = new HashMap<>();
			for (int j = 0; j < n; j++) {
				TreeNode tree;
				if (j + m >= n || j + 1 >= n) {
					tree = new TreeNode(true);
				} else {
					tree = new TreeNode(numArray[j]);

					if (j - 1 >= 0) {
						tree.setMoveMinusOne(new TreeNode(numArray[j - 1]));
					}
					tree.setMovePlusOne(new TreeNode(numArray[j + 1]));
					tree.setMovePlusM(new TreeNode(numArray[j + m]));
					subTrees.put(j, tree);
				}

				subTrees.put(j, tree);
			}

			// Create tree nodes
			for (int j = 0; j < n; j++) {
				subTrees.put(j, new TreeNode(numArray[j]));
			}

			// Connect nodes
			for (int j = 0; j < n; j++) {
				TreeNode node = subTrees.get(j);

				if (j + m >= n || j + 1 >= n) {

				}

				node.setMovePlusM(subTrees.get(j + m));
				node.setMoveMinusOne(subTrees.get(j - 1));
				node.setMovePlusOne(subTrees.get(j + 1));
			}
			// Traverse tree and identify a path of all 0s leading to WIN

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
